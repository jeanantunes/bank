package com.hub.fintech.bank.model.entity;

import com.hub.fintech.bank.controller.PessoaController;
import com.hub.fintech.bank.model.enums.StatusEnum;
import com.hub.fintech.bank.model.enums.TipoContaEnum;
import com.hub.fintech.bank.model.enums.TipoPessoaEnum;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Copyright JotaIT Services
 */

@Entity
@Table(name = "CONTA")
public class Conta extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "PESSOA_TIPO")
    private TipoPessoaEnum pessoaTipo;

    @Column(name = "TIPO_CONTA")
    private TipoContaEnum tipoConta;

    @Column(name = "STATUS")
    private StatusEnum status;

    @JoinColumn(name = "PESSOA_ID")
    private Long pessoaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoaEnum getPessoaTipo() {
        return pessoaTipo;
    }

    public void setPessoaTipo(TipoPessoaEnum pessoaTipo) {
        this.pessoaTipo = pessoaTipo;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
