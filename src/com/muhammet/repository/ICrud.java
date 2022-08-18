package com.muhammet.repository;

import java.util.List;
/**
 * Oluturaca��m�z t�m Repositoryler i�in bir kal�p olu�turduk.
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
