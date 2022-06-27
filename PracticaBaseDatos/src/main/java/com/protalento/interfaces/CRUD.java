package com.protalento.interfaces;

import java.util.List;

public interface CRUD <T , K> {

	T get(K id) throws DaoException; 
	
	List <T> getAll()throws DaoException;
	
	void save(T t)throws DaoException;
	void update(T t)throws DaoException;
	void delete(T t)throws DaoException;
}
