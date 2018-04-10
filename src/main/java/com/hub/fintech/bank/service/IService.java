package com.hub.fintech.bank.service;

// https://github.com/jeanantunes/healthcare/blob/dev/src/main/java/com/healthcare/service/IService.java

public interface IService<T> {
	T save(T entity);

	T findById(Long id);

	/**
	 * Delete the entity
	 * 
	 * @return TODO
	 * 
	 * @return the Redis id deleted
     * @param id
     */
	String deleteById(Long id);
}