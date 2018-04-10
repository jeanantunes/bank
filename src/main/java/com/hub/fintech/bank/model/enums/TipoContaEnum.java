package com.hub.fintech.bank.model.enums;

/**
 * @Copyright JotaIT Services
 */

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
