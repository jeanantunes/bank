package com.hub.fintech.bank.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Copyright JotaIT Services
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "CONTA_ID")})
public class Movimentacao extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "CONTA_ID")
    private Long contaId;

    @Column
    private Long deposito;

    @Column
    private Long saque;

    @Column
    private Long saldo;

    Movimentacao() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getContaId() {
        return contaId;
    }

    @Override
    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Long getDeposito() {
        return deposito;
    }

    public void setDeposito(Long deposito) {
        this.deposito = deposito;
    }

    public Long getSaque() {
        return saque;
    }

    public void setSaque(Long saque) {
        this.saque = saque;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
}
