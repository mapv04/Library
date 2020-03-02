package com.hcl.library;

import com.hcl.library.dao.CustomerDaoImpl;
import com.hcl.library.model.Person;

public class Main {

	public static void main(String[] args) {
		CustomerDaoImpl personDao = new CustomerDaoImpl();
		
		Person diana = new Person(1, "Diana", "Siqueiros");
		
		personDao.create(diana);
	}

}
