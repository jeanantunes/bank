package com.hub.fintech.bank.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Copyright JotaIT Services
 */

// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@Entity // It is used to mark the class as a persistent Java class.
@Table(name = "PF") // Annotation is used to provide the details of the table that this entity will be mapped to.
public class Pf implements Serializable {

    @Id // Annotation is used to define the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // annotation is used to define the primary key generation strategy
    private Long id;

    @Column(name = "NOME") // Annotation with the same name not necessary
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNasc;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
