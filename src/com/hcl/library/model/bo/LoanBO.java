package com.hcl.library.model.bo;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoanBO {
	private int id;
	private CustomerBO customer;
	private StaffBO staff;
	private LocalDate dateOfLoan;
	private LocalDate returnDate;
	private List<BookBO> books;
	
	
	
}
