package br.com.fiap.Bank_api.model;

import java.math.BigDecimal;

public class AccountMovement {
    private Long id;
    private BigDecimal value;

    public AccountMovement() {

    }

    public AccountMovement(Long id, BigDecimal value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
