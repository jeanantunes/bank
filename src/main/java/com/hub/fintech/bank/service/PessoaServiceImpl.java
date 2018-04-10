package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pessoa;
import com.hub.fintech.bank.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public Pessoa save(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    @Override
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        return "Deletado com Sucesso";
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public List<Pessoa> findAll(Sort sort) {
        return pessoaRepository.findAll(sort);
    }

    @Override
    public Page<Pessoa> findAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    @Override
    public List<Pessoa> findAll(Iterable<Long> iterable) {
        return pessoaRepository.findAll(iterable);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Pessoa> List<S> save(Iterable<S> iterable) {
        return pessoaRepository.save(iterable);
    }

    @Override
    public Pessoa findOne(Long aLong) {
        return pessoaRepository.findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return pessoaRepository.exists(aLong);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Pessoa> S saveAndFlush(S s) {
        return pessoaRepository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Pessoa> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pessoa getOne(Long aLong) {
        return pessoaRepository.getOne(aLong);
    }

    @Override
    public <S extends Pessoa> S findOne(Example<S> example) {
        return pessoaRepository.findOne(example);
    }

    @Override
    public <S extends Pessoa> List<S> findAll(Example<S> example) {
        return pessoaRepository.findAll(example);
    }

    @Override
    public <S extends Pessoa> List<S> findAll(Example<S> example, Sort sort) {
        return pessoaRepository.findAll(example, sort);
    }

    @Override
    public <S extends Pessoa> Page<S> findAll(Example<S> example, Pageable pageable) {
        return pessoaRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Pessoa> long count(Example<S> example) {
        return pessoaRepository.count(example);
    }

    @Override
    public <S extends Pessoa> boolean exists(Example<S> example) {
        return pessoaRepository.exists(example);
    }

    @Override
    public void delete(Long id) {
        pessoaRepository.delete(id);
    }

    @Override
    public void delete(Pessoa Pessoa) {
        pessoaRepository.delete(Pessoa);
    }

    @Override
    public void delete(Iterable<? extends Pessoa> iterable) {
        pessoaRepository.delete(iterable);
    }

    @Override
    public void deleteAll() {
        pessoaRepository.deleteAll();
    }
}