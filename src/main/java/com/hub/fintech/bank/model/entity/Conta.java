package com.hub.fintech.bank.model.entity;

import com.hub.fintech.bank.model.enums.StatusEnum;
import com.hub.fintech.bank.model.enums.TipoContaEnum;
import com.hub.fintech.bank.model.enums.TipoPessoaEnum;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Copyright JotaIT Services
 */

// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@Entity // It is used to mark the class as a persistent Java class.
@Table(name = "CONTA") // Annotation is used to provide the details of the table that this entity will be mapped to.
public class Conta implements Serializable {

    @Id // Annotation is used to define the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // annotation is used to define the primary key generation strategy
    private Long id;

    private String nome;

    @Column(name = "PESSOA_TIPO")
    private TipoPessoaEnum pessoaTipo;

    @Column(name = "TIPO_CONTA")
    private TipoContaEnum tipoConta;

    @Column(name = "STATUS")
    private StatusEnum status;

    @OneToOne
    @JoinColumn(name = "PESSOA_ID")
    private Pessoa pessoaId;

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

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }
}
