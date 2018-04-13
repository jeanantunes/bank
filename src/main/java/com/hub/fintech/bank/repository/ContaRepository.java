package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Conta;
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
public class ContaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Conta conta) {
        entityManager.persist(conta);
        return;
    }

    public void delete(Conta conta) {
        if (entityManager.contains(conta))
            entityManager.remove(conta);
        else
            entityManager.remove(entityManager.merge(conta));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from Conta").getResultList();
    }

    public Conta findById(Long id) {
        return entityManager.find(Conta.class, id);
    }

    public void update(Conta conta) {
        entityManager.merge(conta);
        return;
    }
}
