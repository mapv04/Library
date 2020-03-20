package com.hcl.library.model.utils;

import com.hcl.library.model.bo.BookBO;
import com.hcl.library.model.bo.CustomerBO;
import com.hcl.library.model.bo.LoanBO;
import com.hcl.library.model.po.BookPO;
import com.hcl.library.model.po.CustomerPO;
import com.hcl.library.model.po.LoanPO;

public final class ObjectMapper {

	public static final LoanBO map(LoanPO persistenceLoan) {
		return null;
	}
	
	public static final LoanPO map(LoanBO businessLoan) {
		LoanPO loan = new LoanPO();
		loan.setCustomer(map(businessLoan.getCustomer()));
		loan.setDateOfLoan(businessLoan.getDateOfLoan());
		loan.setReturnDate(businessLoan.getReturnDate());
		/*
		 * TODO 
		 * Method to map Staff and a List of Books
		 *
		 *loan.setStaff(map(businessLoan.getStaff()));
		 *loan.setBooks(map(businessLoan.getBooks());
		 */
		return loan;
	}
	
	public static final CustomerBO map(CustomerPO persistenceCustomer) {
		return null;
	}
	
	public static final CustomerPO map(CustomerBO businessCustomer) {
		CustomerPO customer = new CustomerPO();
		customer.setBirthday(businessCustomer.getBirthday());
		customer.setCurp(businessCustomer.getCurp());
		customer.setEmail(businessCustomer.getEmail());
		customer.setName(businessCustomer.getName());
		customer.setLastName(businessCustomer.getLastName());
		customer.setId(businessCustomer.getId());
		customer.setPhone(businessCustomer.getPhone());

		//TODO address
		return customer;
	}
	
	public static final BookBO map(BookPO persistenceBook) {
		BookBO book = new BookBO();
		book.setId(persistenceBook.getId());
		book.setName(persistenceBook.getName());
		book.setIsbn(persistenceBook.getIsbn());
		book.setEdition(persistenceBook.getEdition());
		book.setEditorial(persistenceBook.getEditorial());
		book.setCategory(persistenceBook.getCategory());
		book.setLanguage(persistenceBook.getLanguage());
		book.setBookcover(persistenceBook.getBookcover());
		book.setStatus(persistenceBook.getStatus());
		//book.setAuthors(persistenceBook.getAuthors());
		//book.setLoans(persistenceBook.getLoans());
		
		return book;
	}
	
	public static final BookPO map(BookBO businessBook) {
		BookPO book = new BookPO();
		book.setId(businessBook.getId());
		book.setName(businessBook.getName());
		book.setEdition(businessBook.getEdition());
		book.setEditorial(businessBook.getEdition());
		book.setIsbn(businessBook.getIsbn());
		book.setCategory(businessBook.getCategory());
		book.setLanguage(businessBook.getLanguage());
		book.setBookcover(businessBook.getBookcover());
		book.setStatus(businessBook.getStatus());
		//book.setAuthors(businessBook.getAuthors());
		//book.setLoans(businessBook.getLoans());
		
		return book;
	}
	
}
