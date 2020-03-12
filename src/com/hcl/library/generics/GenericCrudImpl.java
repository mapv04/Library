package com.hcl.library.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public abstract class GenericCrudImpl<T> implements IGenericCrud<T> {
	private List<T> storage= new ArrayList<>();
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("Library");
	private EntityManager em;
	
	private void beginTransaction() {
		this.em.getTransaction().begin();
	}
	
	
	private void commitTransaction() {
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	private void manageCreateException(Exception e) {
		System.out.println(e);
		this.em.getTransaction().rollback();
		this.em.close();
	}
	
	private boolean persist(T entity) {
		beginTransaction();
		try {
			this.em.persist( entity );
		}catch(Exception e) {
			manageCreateException(e);
			return false;
		}
		commitTransaction();
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

	public boolean update(int id, T data) {
		System.out.println("updating");
		return false;
	}
	
	
	public T findById(Class<T> entityClass, int id) {
		this.em = emf.createEntityManager();
		T resource = this.em.find(entityClass, id);
		em.close();
		
		return resource;
	}
	
	public List<T> getStorage(){
		return this.storage;
	}
	
}