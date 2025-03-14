package br.com.fiap.Bank_api.model;

import java.math.BigDecimal;

public class Deposit extends AccountMovement{
    public Deposit() {
    }
    public Deposit(Long id, BigDecimal value) {
        super(id, value);
    }

}
