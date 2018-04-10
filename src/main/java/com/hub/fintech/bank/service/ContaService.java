package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Service
public interface ContaService extends JpaRepository<Conta, Long> {

    Conta save(Conta conta);

    Conta findById(Long id);

    String deleteById(Long id);

    List<Conta> findAll();

    void delete(Long id);
}