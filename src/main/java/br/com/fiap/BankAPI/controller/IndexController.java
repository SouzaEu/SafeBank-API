package br.com.fiap.BankAPI.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index () {
        return "Bank API - Digital Banking System\n" +
               "Nome: Vinícius Souza Carvalho // rm: 556089 // Gabriel Duarte // Rm556972 // turma: 2tdspk";
    }
}
