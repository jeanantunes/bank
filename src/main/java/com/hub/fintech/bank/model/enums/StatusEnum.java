package com.hub.fintech.bank.model.enums;

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
