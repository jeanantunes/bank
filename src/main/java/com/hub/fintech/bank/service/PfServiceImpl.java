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
    public List<Pf> findAll() {
        return pfRepository.findAll();
    }

    @Override
    public List<Pf> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Pf> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Pf> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Pf> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Pf findOne(Long aLong) {
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
    public <S extends Pf> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Pf> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pf getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Pf> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Pf> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Pf> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Pf> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Pf> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Pf> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Pf pf) {
        pfRepository.delete(pf);
    }

    @Override
    public void delete(Iterable<? extends Pf> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}