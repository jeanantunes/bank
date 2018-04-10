package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Service
public interface PjService extends JpaRepository<Pj, Long> {

    Pj save(Pj pj);

    Pj findById(Long id);

    String deleteById(Long id);

    List<Pj> findAll();

    void delete(Long id);
}