package com.hub.fintech.bank.model.entity;

import com.hub.fintech.bank.model.enums.TipoPessoaEnum;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Copyright JotaIT Services
 */

@Entity
@Table(name = "PESSOA")
public class Pessoa extends Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIPO_PESSOA")
    private TipoPessoaEnum pessoaTipo;

    @OneToOne
    @JoinColumn(name = "CPF")
    private Pf cpf;

    @OneToOne
    @JoinColumn(name = "CNPJ")
    private Pj cnpj;

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

    public Pf getCpf() {
        return cpf;
    }

    public void setCpf(Pf cpf) {
        this.cpf = cpf;
    }

    public Pj getCnpj() {
        return cnpj;
    }

    public void setCnpj(Pj cnpj) {
        this.cnpj = cnpj;
    }
}
