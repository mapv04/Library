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
	
		BookPO book1 = new BookPO("Lord of the Rings","Allen & Unwin", "PRW", 8,"Fantasy", "english");
		BookPO book2 = new BookPO("Foundation","Gnome Press", "PRW", 10,"Science fiction", "english");
		BookPO book3 = new BookPO("I Robot","Gnome Press", "PRW", 10,"Science fiction", "english");
		
		LoanPO loan = new LoanPO();
		
		AddressPO address = new AddressPO(12,"swe", "Guadalajara", "Jalisco", "Mexico", 555);
		
		CustomerPO customer = new CustomerPO();
		customer.setName("Jesus");
		customer.setAddress(address);
		
		StaffPO staff = new StaffPO();
		staff.setName("Norris");

		loan.setCustomer(customer);
		loan.setStaff(staff);
		
		em.getTransaction().begin();
		em.persist(loan);
		em.getTransaction().commit();
		

	}

}
