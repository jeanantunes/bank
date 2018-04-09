package com.hub.fintech.bank.model.entity;

import com.hub.fintech.bank.model.enums.TipoPessoaEnum;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Copyright JotaIT Services
 */

// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@Entity // It is used to mark the class as a persistent Java class.
@Table(name = "PESSOA") // Annotation is used to provide the details of the table that this entity will be mapped to.
public class Pessoa implements Serializable {

    @Id // Annotation is used to define the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // annotation is used to define the primary key generation strategy
    private Long id;

    @Column(name = "TIPO_PESSOA") // annotation is used to define the properties of the column that will be mapped to the annotated field
    private TipoPessoaEnum pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPessoaEnum getPessoa() {
        return pessoa;
    }

    public void setPessoa(TipoPessoaEnum pessoa) {
        this.pessoa = pessoa;
    }
}
