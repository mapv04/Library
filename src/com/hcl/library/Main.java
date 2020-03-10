package com.hcl.library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hcl.library.model.po.AddressPO;
import com.hcl.library.model.po.AuthorPO;
import com.hcl.library.model.po.BookPO;
import com.hcl.library.model.po.CustomerPO;
import com.hcl.library.model.po.LoanPO;
import com.hcl.library.model.po.StaffPO;

public class Main {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Library");
		EntityManager em = emf.createEntityManager();
		
		AuthorPO autor1 = new AuthorPO("JRR","Tolkein","British");
		AuthorPO autor2 = new AuthorPO("Isaac","Asimov ","Russian");
	
		BookPO book1 = new BookPO("Lord of the Rings","Allen & Unwin", "PRW","Fantasy", "english");
		BookPO book2 = new BookPO("Foundation","Gnome Press", "PRW","Science fiction", "english");
		BookPO book3 = new BookPO("I Robot","Gnome Press", "PRW","Science fiction", "english");
		BookPO book4 = new BookPO("Time","Gnome Press", "PRW","Science fiction", "english");

		autor1.getBooks().add(book1);
		autor2.getBooks().add(book2);
		autor2.getBooks().add(book3);
		autor2.getBooks().add(book4);
		
		book1.getAuthors().add(autor1);
		book2.getAuthors().add(autor2);
		book3.getAuthors().add(autor2);
		book4.getAuthors().add(autor2);

		LoanPO loan = new LoanPO();
		
		AddressPO address = new AddressPO();
		address.setNumber(123);
		
		
		CustomerPO customer = new CustomerPO();
		customer.setName("Jesus");
		customer.setAddress(address);
		
		StaffPO staff = new StaffPO();
		staff.setName("Norris");

		loan.setCustomer(customer);
		loan.setStaff(staff);
		book1.getLoans().add(loan);
		loan.getBooks().add(book1);
		
		em.getTransaction().begin();
		em.persist(loan);
		
		em.persist(book1);
		em.persist(book2);
		em.persist(book3);
		em.persist(book4);

		em.getTransaction().commit();
		

	}

}
