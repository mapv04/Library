package com.hcl.library.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

	
	private EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
  
	
	public boolean create(T entity) {
		EntityManager em=getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist( entity );
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.print(e);
		}finally {
			em.close();
		}
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