package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Conta;
import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.repository.ContaRepository;
import com.hub.fintech.bank.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Copyright JotaIT Services
 */

// https://stackoverflow.com/questions/41511511/unsatisfieddependencyexception-error-creating-bean-with-name

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.saveAndFlush(pessoa);
    }

    @Override
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        pessoaRepository.delete(id);
        return "Deletado com sucesso.";
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

}