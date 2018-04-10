package com.hub.fintech.bank.service;

import com.hub.fintech.bank.model.entity.Pf;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright JotaIT Services
 */

// https://github.com/jeanantunes/healthcare/blob/dev/src/main/java/com/healthcare/service/EmployeeService.java
@Service
public interface PfService extends IService<Pf> {

    Pf save(Pf pf);

    List<Pf> findAll();

    void delete(Long id);
}