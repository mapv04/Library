package com.hcl.library.generics;

import java.util.List;
import java.util.function.Predicate;

public interface IGenericCrud<T> {

	boolean create(T entity);

	boolean deleteById(int id);

	boolean update(int id, T newData);

	T findById(Class<T> entityClass, int id);

}
