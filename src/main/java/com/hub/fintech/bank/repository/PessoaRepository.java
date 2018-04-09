package com.hub.fintech.bank.repository;

import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.model.enums.TipoPessoaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // This tells Spring to bootstrap the repository during component scan.
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findById(Long id);

}
