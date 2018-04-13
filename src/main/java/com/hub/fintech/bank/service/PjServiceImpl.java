package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pj;
import com.hub.fintech.bank.repository.PjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Service
public abstract class PjServiceImpl implements PjService {

    @Autowired
    PjRepository pjRepository;

    @Override
    public Pj save(Pj pj) {
        pjRepository.save(pj);
        return pj;
    }

    @Override
    public Pj findById(Long id) {
        return pjRepository.findById(id);
    }

    @Override
    public List<Pj> findAll() {
        return pjRepository.findAll();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<Pj> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public void delete(Pj pj) {
        pjRepository.delete(pj);
    }
}