package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Service
public interface MovimentacaoService extends JpaRepository<Movimentacao, Long> {

    Movimentacao save(Movimentacao movimentacao);

    Movimentacao findById(Long id);

    String deleteById(Long id);

    List<Movimentacao> findAll();

    void delete(Long id);
}