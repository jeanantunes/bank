package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Conta;
import com.hub.fintech.bank.model.entity.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

// https://github.com/jeanantunes/healthcare/blob/dev/src/main/java/com/healthcare/service/EmployeeService.java
@Service
public interface PessoaService extends IService<Pessoa> {

    Pessoa save(Pessoa pessoa);

    List<Pessoa> findAll();
}