package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Conta;
import com.hub.fintech.bank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

// https://stackoverflow.com/questions/41511511/unsatisfieddependencyexception-error-creating-bean-with-name
@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Transactional
	public Conta save(Conta conta){
		return contaRepository.saveAndFlush(conta);
	}

	@Override
	public Conta findById(Long id) {
		return contaRepository.findById(id);
	}

	@Override
	public String deleteById(Long id) {
		contaRepository.delete(id);
		return id + " Deleted";
	}

	@Override
	public List<Conta> findAll() {
		return contaRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		contaRepository.delete(id);
	}
}