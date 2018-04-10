package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pf;
import com.hub.fintech.bank.repository.PfRepository;
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
public class PfServiceImpl implements PfService {

    @Autowired
    PfRepository pfRepository;

    @Override
    public Pf save(Pf pf) {
        pfRepository.save(pf);
        return pf;
    }

    @Override
    public Pf findById(Long id) {
        return pfRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        return "Deletado com Sucesso";
    }

    @Override
    public List<Pf> findAll() {
        return pfRepository.findAll();
    }

    @Override
    public List<Pf> findAll(Sort sort) {
        return pfRepository.findAll(sort);
    }

    @Override
    public Page<Pf> findAll(Pageable pageable) {
        return pfRepository.findAll(pageable);
    }

    @Override
    public List<Pf> findAll(Iterable<Long> iterable) {
        return pfRepository.findAll(iterable);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Pf> List<S> save(Iterable<S> iterable) {
        return pfRepository.save(iterable);
    }

    @Override
    public Pf findOne(Long aLong) {
        return pfRepository.findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return pfRepository.exists(aLong);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Pf> S saveAndFlush(S s) {
        return pfRepository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Pf> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pf getOne(Long aLong) {
        return pfRepository.getOne(aLong);
    }

    @Override
    public <S extends Pf> S findOne(Example<S> example) {
        return pfRepository.findOne(example);
    }

    @Override
    public <S extends Pf> List<S> findAll(Example<S> example) {
        return pfRepository.findAll(example);
    }

    @Override
    public <S extends Pf> List<S> findAll(Example<S> example, Sort sort) {
        return pfRepository.findAll(example, sort);
    }

    @Override
    public <S extends Pf> Page<S> findAll(Example<S> example, Pageable pageable) {
        return pfRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Pf> long count(Example<S> example) {
        return pfRepository.count(example);
    }

    @Override
    public <S extends Pf> boolean exists(Example<S> example) {
        return pfRepository.exists(example);
    }

    @Override
    public void delete(Long id) {
        pfRepository.delete(id);
    }

    @Override
    public void delete(Pf pf) {
        pfRepository.delete(pf);
    }

    @Override
    public void delete(Iterable<? extends Pf> iterable) {
        pfRepository.delete(iterable);
    }

    @Override
    public void deleteAll() {
        pfRepository.deleteAll();
    }
}