package br.com.fiap.Bank_api.controller;

import br.com.fiap.Bank_api.model.Account;
import br.com.fiap.Bank_api.model.Deposit;
import br.com.fiap.Bank_api.model.Transfer;
import br.com.fiap.Bank_api.model.Withdraw;
import br.com.fiap.Bank_api.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private ContaService cs = new ContaService();
    private List<Account> repository = new ArrayList<>();


    @GetMapping
    private List<Account> index() {
        return repository;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Account create(@RequestBody Account account) {
        System.out.println("Salvando conta de: " + account.getNomeTitular());
        cs.validateAccount(account);
        repository.add(account);
        System.out.println("Conta salva com sucesso!");
        return account;
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Account> getCpf(@PathVariable String cpf) {
        System.out.println("Buscando conta de cpf: " + cpf);
        return ResponseEntity.ok(getByCpf(cpf));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Account> getId(@PathVariable Long id) {
        System.out.println("Buscando conta de id: " + id);
        return ResponseEntity.ok(getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        getById(id).setAtivo(false);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/deposit")
    public ResponseEntity<Account> deposit(@RequestBody Deposit deposit) {
        return ResponseEntity.ok(cs.deposit(getById(deposit.getId()), deposit.getValue()));
    }

    @PatchMapping("/withdraw")
    public ResponseEntity<Account> withdraw(@RequestBody Withdraw withdraw) {
        return ResponseEntity.ok(cs.withdraw(getById(withdraw.getId()), withdraw.getValue()));
    }

    @PatchMapping("/transfer")
    public ResponseEntity<Account> transfer(@RequestBody Transfer transfer) {
        return ResponseEntity.ok(cs.transfer(getById(transfer.getIdDestiny()), getById(transfer.getIdOrigin()), transfer));
    }

    // Métodos

    private Account getByCpf(String cpf) {
        var conta = repository.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();

        if (conta.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de cpf (" + cpf + ") não encontrada");
        }

        return conta.get();
    }

    private Account getById(Long id) {
        var conta = repository.stream()
                .filter(c -> c.getNumero().equals(id))
                .findFirst();

        if (conta.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de id (" + id + ") não encontrada");
        }

        return conta.get();
    }


}
