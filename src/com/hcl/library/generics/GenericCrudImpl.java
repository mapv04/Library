package com.hcl.library.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hcl.library.model.po.BookPO;

public abstract class GenericCrudImpl<T> implements IGenericCrud<T> {
	private List<T> storage= new ArrayList<>();
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("Library");
	private EntityManager em;
	private final Class<T> name;
	
	public GenericCrudImpl(Class<T> name){
		this.em = emf.createEntityManager();
		this.name = name;
	}

	private void manageCreateException(Exception e) {
		System.out.println(e);
		this.em.getTransaction().rollback();
		//this.em.close();
	}
	
	private boolean persist(T entity) {
		em.getTransaction().begin();
		try {
			this.em.persist( entity );
		}catch(Exception e) {
			manageCreateException(e);
			return false;
		}
		em.getTransaction().commit();
		return true;
	}
	
	
	public boolean create(T entity) {
		this.em=emf.createEntityManager();
		return persist(entity);
	}

	public boolean deleteById(int id) {
		System.out.println("deleting");
		return false;
	}

	public T update( T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	
		return entity;		
	}
	
	
	public T findById(int id) {
		
		this.em = emf.createEntityManager();
		T entity = this.em.find(name, id);		
		return entity;
	}
	
	
	public void closeEntityManager() {
		em.close();
	}
	
	public List<T> getStorage(){
		return this.storage;
	}
	
	public List<T> findAll() {
		
		StringBuilder out = new StringBuilder("SELECT t from ").append(name.getSimpleName()).append(" t");
        System.out.println(out);
		return em.createQuery(out.toString()).getResultList();
	}
	
	public T find(Predicate<T> predicate) {
		T entity = null;
		Optional<T> optionalEntity = findAll().stream().filter(predicate).findAny();

		if (optionalEntity.isPresent()) {
			return optionalEntity.get();
		}
		return entity;
	}
	
	public List<T> findAll(Predicate<T> predicate) {
		 List<T> entities = findAll().stream().filter(predicate).collect(Collectors.toList());	
		return entities;
	}

	
	
}