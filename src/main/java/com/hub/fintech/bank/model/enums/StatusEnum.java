package com.hub.fintech.bank.model.enums;

/**
 * @Copyright JotaIT Services
 */

public enum StatusEnum {

    ATIVO("A"),
    BLOQUEADO("B"),
    CANCELADO("C");

    private String descricao;


    private StatusEnum(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
