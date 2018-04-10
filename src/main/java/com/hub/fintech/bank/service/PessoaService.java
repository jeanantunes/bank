package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Service
public interface PessoaService extends JpaRepository<Pessoa, Long> {

    Pessoa save(Pessoa pessoa);

    Pessoa findById(Long id);

    String deleteById(Long id);

    List<Pessoa> findAll();
}