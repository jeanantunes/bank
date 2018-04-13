package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Pessoa;
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
public class PessoaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);
        return;
    }

    public void delete(Pessoa pessoa) {
        if (entityManager.contains(pessoa))
            entityManager.remove(pessoa);
        else
            entityManager.remove(entityManager.merge(pessoa));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from Pessoa").getResultList();
    }

    public Pessoa findById(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    public void update(Pessoa pessoa) {
        entityManager.merge(pessoa);
        return;
    }
}
