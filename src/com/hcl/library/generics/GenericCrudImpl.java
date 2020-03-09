package com.hcl.library.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericCrudImpl<T> implements IGenericCrud<T> {
	private List<T> storage= new ArrayList<>();
	
	
	public boolean create(T entity) {
		System.out.println("creating: " +entity.getClass().getSimpleName());
	
		return false;
	}

	public boolean deleteById(int id) {
		System.out.println("deleting");
		return false;
	}

	public boolean update(int id, T data) {
		System.out.println("updating");
		return false;
	}
	
	/*
	public T findBy(Predicate<T> search) {
		System.out.println("find");
		Optional<T> entity = this.getStorage().stream().filter(search).findAny();
		return  (T) entity;
	}*/
	
	public List<T> getStorage(){
		return this.storage;
	}
	
}