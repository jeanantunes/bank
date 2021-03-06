package com.hub.fintech.bank.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Copyright JotaIT Services
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "CPF")})
public class Pf extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @JoinColumn(name = "CPF")
    private Long cpf;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNasc;

    Pf() {
    }

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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
