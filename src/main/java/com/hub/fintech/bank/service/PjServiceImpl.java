package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pj;
import com.hub.fintech.bank.repository.PjRepository;
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
public class PjServiceImpl implements PjService {

    @Autowired
    PjRepository pjRepository;

    @Override
    public Pj save(Pj pj) {
        pjRepository.save(pj);
        return pj;
    }

    @Override
    public Pj findById(Long id) {
        return pjRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        return "Deletado com Sucesso";
    }

    @Override
    public List<Pj> findAll() {
        return pjRepository.findAll();
    }

    @Override
    public List<Pj> findAll(Sort sort) {
        return pjRepository.findAll(sort);
    }

    @Override
    public Page<Pj> findAll(Pageable pageable) {
        return pjRepository.findAll(pageable);
    }

    @Override
    public List<Pj> findAll(Iterable<Long> iterable) {
        return pjRepository.findAll(iterable);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Pj> List<S> save(Iterable<S> iterable) {
        return pjRepository.save(iterable);
    }

    @Override
    public Pj findOne(Long aLong) {
        return pjRepository.findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return pjRepository.exists(aLong);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Pj> S saveAndFlush(S s) {
        return pjRepository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Pj> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pj getOne(Long aLong) {
        return pjRepository.getOne(aLong);
    }

    @Override
    public <S extends Pj> S findOne(Example<S> example) {
        return pjRepository.findOne(example);
    }

    @Override
    public <S extends Pj> List<S> findAll(Example<S> example) {
        return pjRepository.findAll(example);
    }

    @Override
    public <S extends Pj> List<S> findAll(Example<S> example, Sort sort) {
        return pjRepository.findAll(example, sort);
    }

    @Override
    public <S extends Pj> Page<S> findAll(Example<S> example, Pageable pageable) {
        return pjRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Pj> long count(Example<S> example) {
        return pjRepository.count(example);
    }

    @Override
    public <S extends Pj> boolean exists(Example<S> example) {
        return pjRepository.exists(example);
    }

    @Override
    public void delete(Long id) {
        pjRepository.delete(id);
    }

    @Override
    public void delete(Pj pj) {
        pjRepository.delete(pj);
    }

    @Override
    public void delete(Iterable<? extends Pj> iterable) {
        pjRepository.delete(iterable);
    }

    @Override
    public void deleteAll() {
        pjRepository.deleteAll();
    }
}