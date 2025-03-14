package br.com.fiap.BankAPI.model;

import java.math.BigDecimal;

public class Deposit extends AccountMovement {
    public Deposit() {}

    public Deposit(Long id, BigDecimal value) {
        super(id, value);
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do deposito deve ser positivo.");
        }
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + getIdOrigin() +
                ", value=" + getValue() +
                '}';
    }
}
