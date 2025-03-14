package br.com.fiap.Bank_API.controller;

import br.com.fiap.Bank_API.model.Conta;
import br.com.fiap.Bank_API.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private ContaService cts = new ContaService();
    private List<Conta> repository = new ArrayList<>();

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conta create(@RequestBody Conta conta) {
        System.out.println("Salvando a conta de " + conta.getNomeTitular());
        cts.validaConta(conta);
        repository.add(conta);
        System.out.println("Conta salva com sucesso!");
        return conta;
    }
}
