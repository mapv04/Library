package com.hcl.library.generics;

public interface IGenericCrud<T> {

	boolean create(T entity);

	boolean deleteById(int id);

	boolean update(int id);

	T findById(int id);

}
