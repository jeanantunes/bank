package com.hub.fintech.bank.service;

/**
 * @Copyright JotaIT Services
 */

// https://github.com/jeanantunes/healthcare/blob/dev/src/main/java/com/healthcare/service/IService.java

public interface IService<T> {
    T save(T entity);

    T findById(Long id);

    /**
     * Delete the entity
     *
     * @param id
     * @return the Redis id deleted
     */
    String deleteById(Long id);
}