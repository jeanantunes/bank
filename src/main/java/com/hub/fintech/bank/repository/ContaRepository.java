package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Repository // This tells Spring to bootstrap the repository during component scan.
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta findById(Long id);
}
