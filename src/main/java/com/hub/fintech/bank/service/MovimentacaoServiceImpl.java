package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Movimentacao;
import com.hub.fintech.bank.repository.MovimentacaoRepository;
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
public class MovimentacaoServiceImpl implements MovimentacaoService {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Override
    public Movimentacao save(Movimentacao movimentacao) {
        movimentacaoRepository.save(movimentacao);
        return movimentacao;
    }

    @Override
    public Movimentacao findById(Long id) {
        return movimentacaoRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }

    @Override
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    @Override
    public List<Movimentacao> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Movimentacao> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Movimentacao> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Movimentacao> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Movimentacao findOne(Long aLong) {
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
    public <S extends Movimentacao> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Movimentacao> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Movimentacao getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Movimentacao> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Movimentacao> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Movimentacao> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Movimentacao> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Movimentacao> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Movimentacao> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Movimentacao movimentacao) {
        movimentacaoRepository.delete(movimentacao);
    }

    @Override
    public void delete(Iterable<? extends Movimentacao> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}