package br.com.fiap.Bank_api.model;

import java.math.BigDecimal;

public class Withdraw extends AccountMovement{
    public Withdraw() {
    }

    public Withdraw(Long id, BigDecimal value) {
        super(id, value);
    }
}
