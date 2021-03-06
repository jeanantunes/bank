package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Conta;
import com.hub.fintech.bank.repository.ContaRepository;
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
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Override
    public Conta save(Conta conta) {
        contaRepository.save(conta);
        return conta;
    }

    @Override
    public Conta findById(Long id) {
        return contaRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }

    @Override
    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    @Override
    public List<Conta> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Conta> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Conta> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Conta> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Conta findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Conta> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Conta> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Conta getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Conta> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Conta> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Conta> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Conta> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Conta> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Conta> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Conta conta) {
        contaRepository.delete(conta);
    }

    @Override
    public void delete(Iterable<? extends Conta> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}