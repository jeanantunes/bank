package com.hub.fintech.bank.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Entity
@Table(name = "PJ")
public class Pj extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "CNPJ")
    private Long cnpj;

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

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }
}
