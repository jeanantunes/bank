package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pf;
import com.hub.fintech.bank.repository.PfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Copyright JotaIT Services
 */

// https://stackoverflow.com/questions/41511511/unsatisfieddependencyexception-error-creating-bean-with-name

@Service
public class PfServiceImpl implements PfService {

    @Autowired
    private PfRepository pfRepository;

    @Transactional
    public Pf save(Pf pf) {
        return pfRepository.saveAndFlush(pf);
    }

    @Override
    public Pf findById(Long id) {
        return pfRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        pfRepository.delete(id);
        return "Deletado com sucesso.";
    }

    @Override
    public List<Pf> findAll() {
        return pfRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        pfRepository.delete(id);
    }
}