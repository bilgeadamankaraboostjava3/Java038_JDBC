package com.muhammet.repository;

import java.util.List;
/**
 * Oluturacaðýmýz tüm Repositoryler için bir kalýp oluþturduk.
 * 
 * @author MuhammetAli
 *
 * @param <T>
 */
public interface ICrud<T> {

	void save(T t);
	void update(T t);
	void delete(int id);
	List<T> findAll();
	T findById(int id);
	List<T> findByColumnValue(String columnName,Object value);
}
