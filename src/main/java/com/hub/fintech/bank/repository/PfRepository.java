package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Pf;
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
public class PfRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Pf pf) {
        entityManager.persist(pf);
        return;
    }

    public void delete(Pf pf) {
        if (entityManager.contains(pf))
            entityManager.remove(pf);
        else
            entityManager.remove(entityManager.merge(pf));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from Pf").getResultList();
    }

    public Pf findById(Long id) {
        return entityManager.find(Pf.class, id);
    }

    public void update(Pf pf) {
        entityManager.merge(pf);
        return;
    }
}
