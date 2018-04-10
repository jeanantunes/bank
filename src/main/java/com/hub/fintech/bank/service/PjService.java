package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pj;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

// https://github.com/jeanantunes/healthcare/blob/dev/src/main/java/com/healthcare/service/EmployeeService.java
@Service
public interface PjService extends IService<Pj> {

    Pj save(Pj pj);

    List<Pj> findAll();

    void delete(Long id);
}