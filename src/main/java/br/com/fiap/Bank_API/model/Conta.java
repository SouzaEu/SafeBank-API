package br.com.fiap.Bank_API.model;

import java.time.LocalDate;

public class Conta {

    private long agencia;
    private long numero;
    private double saldo;
    private boolean ativo;
    private String cpf;
    private String nomeTitular;
    private TipoConta tipo;
    private LocalDate dataAbertura;

    public Conta(long numero, long agencia, String nomeTitular, String cpf, TipoConta tipo, Double saldo) {

        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.ativo = true;
        this.cpf = cpf;
        this.nomeTitular = nomeTitular;
        this.tipo = tipo;
        this.dataAbertura = LocalDate.now();
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public long getAgencia() {
        return agencia;
    }

    public void setAgencia(long agencia) {
        this.agencia = agencia;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }
}
