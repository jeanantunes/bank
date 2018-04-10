package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Copyright JotaIT Services
 */

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findById(Long id);

}
