package com.hcl.library.model.po;

import java.util.Date;
import java.util.List;

import com.hcl.library.StatusLoan;

import lombok.Builder;

@Builder
public class LoanBookPO {
	private int id;
	private CustomerPO customer;
	private StaffPO staff;
	private Date dateOfLoan;
	private Date returnDate;
	private List<BookPO> Books;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CustomerPO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerPO customer) {
		this.customer = customer;
	}
	public StaffPO getStaff() {
		return staff;
	}
	public void setStaff(StaffPO staff) {
		this.staff = staff;
	}
	public Date getDateOfLoan() {
		return dateOfLoan;
	}
	public void setDateOfLoan(Date dateOfLoan) {
		this.dateOfLoan = dateOfLoan;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public List<BookPO> getBooks() {
		return Books;
	}
	public void setBooks(List<BookPO> books) {
		Books = books;
	}
	
	
	
	
	
}
