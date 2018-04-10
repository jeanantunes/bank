package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Pf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Copyright JotaIT Services
 */

@Repository
public interface PfRepository extends JpaRepository<Pf, Long> {

    Pf findById(Long id);
}
