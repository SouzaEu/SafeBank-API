package br.com.fiap.BankAPI.controller;

import br.com.fiap.BankAPI.model.*;
import br.com.fiap.BankAPI.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private final AccountService accountService = new AccountService();
    private final List<Account> repository = new CopyOnWriteArrayList<>();

    @GetMapping
    public List<Account> listarContas() {
        return repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account criarConta(@RequestBody Account account) {
        System.out.println("Salvando conta de: " + account.getNomeTitular());
        accountService.validateAccount(account);
        repository.add(account);
        System.out.println("Conta salva com sucesso!");
        return account;
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Account> buscarPorCpf(@PathVariable String cpf) {
        System.out.println("Buscando conta pelo CPF: " + cpf);
        return ResponseEntity.ok(encontrarContaPorCpf(cpf));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Account> buscarPorId(@PathVariable Long id) {
        System.out.println("Buscando conta pelo ID: " + id);
        return ResponseEntity.ok(encontrarContaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativarConta(@PathVariable Long id) {
        encontrarContaPorId(id).setAtivo(false);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/deposit")
    public ResponseEntity<Account> depositar(@RequestBody Deposit deposit) {
        return ResponseEntity.ok(accountService.deposit(encontrarContaPorId(deposit.getIdOrigin()), deposit.getValue()));
    }

    @PatchMapping("/withdraw")
    public ResponseEntity<Account> sacar(@RequestBody Withdraw withdraw) {
        return ResponseEntity.ok(accountService.withdraw(encontrarContaPorId(withdraw.getIdOrigin()), withdraw.getValue()));
    }

    @PatchMapping("/transfer")
    public ResponseEntity<Account> transferir(@RequestBody Transfer transfer) {
        return ResponseEntity.ok(accountService.transfer(
                encontrarContaPorId(transfer.getIdDestiny()),
                encontrarContaPorId(transfer.getIdOrigin()),
                transfer.getValue()
        ));
    }

    // Metodos auxiliares
    private Account encontrarContaPorCpf(String cpf) {
        return repository.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta com CPF " + cpf + " não encontrada"));
    }

    private Account encontrarContaPorId(Long id) {
        return repository.stream()
                .filter(c -> c.getNumero().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta com ID " + id + " não encontrada"));
    }
}