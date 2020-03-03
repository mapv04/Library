package com.hcl.library.model;

import java.util.Date;
import java.util.List;

import com.hcl.library.StatusLoan;

import lombok.Builder;

@Builder
public class LoanBook {
	private int id;
	private Customer customer;
	private Staff staff;
	private Date dateOfLoan;
	private Date returnDate;
	private List<Book> Books;
	
	
	
}
