package com.hcl.library.dto;

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
	
	public static final CustomerPO map(CustomerBO businessCustomer) {
		CustomerPO customer = new CustomerPO();
		
		//TODO address
		return customer;
	}
	
	
	
}
