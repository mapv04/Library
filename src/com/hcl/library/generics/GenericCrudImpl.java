package com.hcl.library.generics;

public abstract class GenericCrudImpl<T> implements IGenericCrud<T> {

	public boolean create(T entity) {
		System.out.println("creating");
		return false;
	}

	public boolean deleteById(int id) {
		System.out.println("deleting");
		return false;
	}

	public boolean update(int id) {
		System.out.println("updating");
		return false;
	}

	public T findById(int id) {
		System.out.println("find");

		return null;
	}

}