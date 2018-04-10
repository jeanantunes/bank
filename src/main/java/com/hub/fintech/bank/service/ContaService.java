package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Conta;
import org.springframework.stereotype.Service;

import java.util.List;

// https://github.com/jeanantunes/healthcare/blob/dev/src/main/java/com/healthcare/service/EmployeeService.java
@Service
public interface ContaService extends IService<Conta> {

	Conta save(Conta conta);

	List<Conta> findAll();

	void delete(Long id);
}