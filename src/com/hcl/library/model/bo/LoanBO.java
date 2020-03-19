package com.hcl.library.model.bo;

import java.util.Date;
import java.util.List;

import com.hcl.library.StatusLoan;

import lombok.Builder;

@Builder
public class LoanBO {
	private int id;
	private CustomerBO customer;
	private StaffBO staff;
	private Date dateOfLoan;
	private Date returnDate;
	private List<BookBO> Books;
	
	
	
}
