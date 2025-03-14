package br.com.fiap.BankAPI.model;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountMovement {
    private Long id;
    private BigDecimal value;

    public AccountMovement() {}

    public AccountMovement(Long id, BigDecimal value) {
        this.id = id;
        this.value = value;
    }

    public Long getIdOrigin() { return id; }
    public void setIdOrigin(Long id) { this.id = id; }

    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }

    public boolean isValuePositive() { return value != null && value.compareTo(BigDecimal.ZERO) > 0; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMovement that = (AccountMovement) o;
        return Objects.equals(id, that.id) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
