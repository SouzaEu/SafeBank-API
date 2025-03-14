package br.com.fiap.BankAPI.model;

import java.math.BigDecimal;

public class Withdraw extends AccountMovement {
    public Withdraw() {}

    public Withdraw(Long id, BigDecimal value) {
        super(id, value);
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "id=" + getIdOrigin() +
                ", value=" + getValue() +
                '}';
    }
}
