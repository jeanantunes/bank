package com.hub.fintech.bank.model.enums;

/**
 * @Copyright JotaIT Services
 */

public enum TipoPessoaEnum {

    CPF("PF"),
    CNPJ("PJ");

    private String descricao;


    private TipoPessoaEnum(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
