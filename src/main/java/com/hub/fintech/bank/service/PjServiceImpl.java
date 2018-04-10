package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pj;
import com.hub.fintech.bank.repository.PjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Copyright JotaIT Services
 */

// https://stackoverflow.com/questions/41511511/unsatisfieddependencyexception-error-creating-bean-with-name

@Service
public class PjServiceImpl implements PjService {

    @Autowired
    private PjRepository pjRepository;

    @Transactional
    public Pj save(Pj pj) {
        return pjRepository.saveAndFlush(pj);
    }

    @Override
    public Pj findById(Long id) {
        return pjRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        pjRepository.delete(id);
        return "Deletado com sucesso.";
    }

    @Override
    public List<Pj> findAll() {
        return pjRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        pjRepository.delete(id);
    }
}