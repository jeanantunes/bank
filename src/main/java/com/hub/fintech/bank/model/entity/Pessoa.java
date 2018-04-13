package com.hub.fintech.bank.model.entity;

import com.hub.fintech.bank.model.enums.TipoPessoaEnum;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Copyright JotaIT Services
 */

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIPO_PESSOA")
    private TipoPessoaEnum pessoaTipo;

    @JoinColumn(name = "CPF")
    private Long cpf;

    @JoinColumn(name = "CNPJ")
    private Long cnpj;

    @JoinColumn(name = "CONTA_ID")
    private Long contaId;

    Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPessoaEnum getPessoaTipo() {
        return pessoaTipo;
    }

    public void setPessoaTipo(TipoPessoaEnum pessoaTipo) {
        this.pessoaTipo = pessoaTipo;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }
}
