package com.hcl.library.generics;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericCrudImpl<T> implements IGenericCrud<T> {
	private List<T> storage= new ArrayList<>();
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("Library");
	private EntityManager em;
	

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
		em.getTransaction();
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
		T entity = this.em.find(getDaoClass(), id);		
		return entity;
	}
	
	
	public void closeEntityManager() {
		em.close();
	}
	
	public List<T> getStorage(){
		return this.storage;
	}
	
	public List<T> findAll() {
        return em.createQuery("Select t from "+ getPOClassName() + " t").getResultList();
	}
	
	public abstract Class<T> getDaoClass();

	public abstract String getPOClassName();
	
}