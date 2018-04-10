package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Pj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Copyright JotaIT Services
 */

@Repository // This tells Spring to bootstrap the repository during component scan.
public interface PjRepository extends JpaRepository<Pj, Long> {

    Pj findById(Long id);
}
