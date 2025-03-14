package br.com.fiap.Bank_API.service;

import br.com.fiap.Bank_API.model.Conta;
import br.com.fiap.Bank_API.model.TipoConta;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.EnumSet;

public class ContaService {

    public void validaConta(Conta conta) {
        if (isNullOuVazio(conta.getNomeTitular()) ||
                isNullOuVazio(conta.getCpf()) ||
                isSaldoInvalido(conta.getSaldo()) ||
                isTipoInvalido(conta.getTipo()) ||
                isDataAberturaInvalida(conta.getDataAbertura())) {

            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Erro no corpo da requisição");
        }
    }

    private boolean isNullOuVazio(String s) {
        return s == null || s.trim().isEmpty();
    }

    private boolean isSaldoInvalido(Double saldo) {
        return saldo == null || saldo < 0;
    }

    private boolean isTipoInvalido(TipoConta tipo) {
        return tipo == null || !EnumSet.allOf(TipoConta.class).contains(tipo);
    }

    private boolean isDataAberturaInvalida(LocalDate data) {
        return data == null || LocalDate.now().isBefore(data);
    }
}
