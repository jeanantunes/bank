package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Movimentacao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Repository
@Transactional
public class MovimentacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Movimentacao movimentacao) {
        entityManager.persist(movimentacao);
        return;
    }

    public void delete(Movimentacao movimentacao) {
        if (entityManager.contains(movimentacao))
            entityManager.remove(movimentacao);
        else
            entityManager.remove(entityManager.merge(movimentacao));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from Movimentacao").getResultList();
    }

    public Movimentacao findById(Long id) {
        return entityManager.find(Movimentacao.class, id);
    }

    public void update(Movimentacao movimentacao) {
        entityManager.merge(movimentacao);
        return;
    }
}
