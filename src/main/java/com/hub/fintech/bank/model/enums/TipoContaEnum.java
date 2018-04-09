package com.hub.fintech.bank.model.enums;

public enum TipoContaEnum {

    MATRIZ("M"),
    FILIAL("F");

    private String descricao;


    private TipoContaEnum(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
