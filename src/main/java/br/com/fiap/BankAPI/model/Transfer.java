package br.com.fiap.BankAPI.model;

import java.math.BigDecimal;

public class Transfer extends AccountMovement {
    private Long idDestiny;

    public Transfer() {}

    public Transfer(Long idOrigin, Long idDestiny, BigDecimal value) {
        super(idOrigin, value);
        this.idDestiny = idDestiny;
    }

    public Long getIdDestiny() { return idDestiny; }
    public void setIdDestiny(Long idDestiny) { this.idDestiny = idDestiny; }
}
