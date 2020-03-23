package com.hcl.library.dto;


import com.hcl.library.model.bo.LoanBO;
import com.hcl.library.model.po.LoanPO;

public final class LoanDTO {

	public static final LoanBO map(LoanPO persistenceLoan) {
		return null;
	}
	
	public static final LoanPO map(LoanBO businessLoan) {
		LoanPO loan = new LoanPO();
		loan.setCustomer(CustomerDto.map(businessLoan.getCustomer()));
		loan.setStaff(StaffDto.map(businessLoan.getStaff()));
		loan.setDateOfLoan(businessLoan.getDateOfLoan());
		loan.setReturnDate(businessLoan.getReturnDate());
		loan.setBooks(BookDto.map(businessLoan.getBooks()));

		return loan;
	}
	
	
}
