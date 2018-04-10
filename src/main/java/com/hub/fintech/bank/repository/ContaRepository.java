package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Copyright JotaIT Services
 */

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta findById(Long id);
}
