package br.com.fiap.BankAPI.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Account {
    private Long numero;
    private Long agencia;
    private String nomeTitular;
    private String cpf;
    private LocalDate dataAbertura;
    private BigDecimal saldo;
    private boolean ativo;
    private AccountType tipo;

    public Account(Long numero, Long agencia, String nomeTitular, String cpf, AccountType tipo, BigDecimal saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        this.dataAbertura = LocalDate.now();
        this.saldo = saldo;
        this.ativo = true;
        this.tipo = tipo;
    }

    // Getters e Setters
    public Long getNumero() { return numero; }
    public void setNumero(Long numero) { this.numero = numero; }

    public Long getAgencia() { return agencia; }
    public void setAgencia(Long agencia) { this.agencia = agencia; }

    public String getNomeTitular() { return nomeTitular; }
    public void setNomeTitular(String nomeTitular) { this.nomeTitular = nomeTitular; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public AccountType getTipo() { return tipo; }
    public void setTipo(AccountType tipo) { this.tipo = tipo; }

    // Metodos auxiliares
    public void ativar() { this.ativo = true; }
    public void desativar() { this.ativo = false; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(numero, account.numero) && Objects.equals(cpf, account.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, cpf);
    }
}
