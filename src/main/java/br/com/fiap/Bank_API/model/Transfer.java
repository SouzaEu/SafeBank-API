package br.com.fiap.Bank_api.model;

import java.math.BigDecimal;

public class Transfer extends AccountMovement {
    private Long idDestiny;

    // Qual seria a melhor maneira de renomar o atributo da classe pai (id) para (idOrigin)?
    private Long idOrigin;

    public Transfer() {
    }

    public Transfer(Long idOrigin, Long idDestiny, BigDecimal value) {
        super(idOrigin, value);
        this.idOrigin = idOrigin;
        this.idDestiny = idDestiny;
    }

    public Long getIdDestiny() {
        return idDestiny;
    }

    public void setIdDestiny(Long idDestiny) {
        this.idDestiny = idDestiny;
    }

    public Long getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(Long idOrigin) {
        this.idOrigin = idOrigin;
    }
}
