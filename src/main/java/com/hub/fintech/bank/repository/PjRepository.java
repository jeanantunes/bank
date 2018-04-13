package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Pj;
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
public class PjRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Pj pj) {
        entityManager.persist(pj);
        return;
    }

    public void delete(Pj pj) {
        if (entityManager.contains(pj))
            entityManager.remove(pj);
        else
            entityManager.remove(entityManager.merge(pj));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from Pj").getResultList();
    }

    public Pj findById(Long id) {
        return entityManager.find(Pj.class, id);
    }

    public void update(Pj pj) {
        entityManager.merge(pj);
        return;
    }
}
