package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Service
public interface PfService extends JpaRepository<Pf, Long> {

    Pf save(Pf pf);

    Pf findById(Long id);

    List<Pf> findAll();

    void delete(Long id);
}