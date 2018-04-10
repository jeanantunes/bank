package com.hub.fintech.bank.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Copyright JotaIT Services
 */

// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@Entity // It is used to mark the class as a persistent Java class.
@Table(name = "PJ") // Annotation is used to provide the details of the table that this entity will be mapped to.
public class Pj implements Serializable {

    @Id // Annotation is used to define the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // annotation is used to define the primary key generation strategy
    private Long id;

    @Column(name = "RAZAO_SOCIAL") // Annotation with the same name not necessary
    private String razaoSocial;

    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "CNPJ")
    private String cnpj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
