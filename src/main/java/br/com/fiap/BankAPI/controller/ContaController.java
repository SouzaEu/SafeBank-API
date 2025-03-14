package br.com.fiap.Bank_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.Bank_API.model.Conta;
import br.com.fiap.Bank_API.service.ContaService;

@RestController
public class ContaController {

    @Autowired
    ContaService service;

    @GetMapping("contas")
    public java.util.List<Conta> index() {
        return service.findAll();
    }

    @PostMapping("contas")
    public Conta create(@RequestBody Conta conta) {
        return service.save(conta);
    }

    @GetMapping("contas/{id}")
    public Conta get(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada com o ID: " + id));
    }

    @GetMapping("contas/cpf/{cpf}")
    public Conta getByCpf(@PathVariable String cpf) {
        return service.findByCpf(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada com o CPF: " + cpf));
    }

    @PutMapping("contas/{id}/encerrar")
    public Conta encerrar(@PathVariable Long id) {
        return service.encerrar(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encerrar a conta com ID: " + id));
    }

    @PutMapping("contas/{id}/deposito")
    public Conta deposito(@PathVariable Long id, @RequestBody Conta conta) {
        return service.deposito(id, conta.getSaldo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível realizar o depósito na conta com ID: " + id));
    }

    @PutMapping("contas/{id}/saque")
    public Conta saque(@PathVariable Long id, @RequestBody Conta conta) {
        return service.saque(id, conta.getSaldo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível realizar o saque na conta com ID: " + id));
    }

    @PutMapping("contas/{origem}/pix/{destino}")
    public Conta pix(@PathVariable Long origem, @PathVariable Long destino, @RequestBody Conta conta) {
        return service.pix(origem, destino, conta.getSaldo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível realizar o PIX entre as contas especificadas"));
    }
}

