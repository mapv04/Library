package com.hcl.library;

import com.hcl.library.model.po.BookPO;
import com.hcl.library.service.BookService;

public class Main {

	public static void main(String[] args) {
	
		
		BookService bookdao = new BookService();
		//BookPO book1 = new BookPO("Lord of the Rings","Allen & Unwin", "PRW","Fantasy", "english");
		BookPO book2 = new BookPO("Foundation","Gnome Press", "PRW","Science fiction", "english");

		
		//bookdao.create(book1);
		//bookdao.create(book2);
		BookPO b=bookdao.findById(1);
		//b.setName("Lord2");
		//System.out.println(b.toString());
		//bookdao.update(b);
		bookdao.findAll().forEach(book -> System.out.println(book.toString()));;
		
		bookdao.closeEntityManager();
		/*
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
		*/

	}

}
