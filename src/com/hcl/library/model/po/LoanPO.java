package com.hcl.library.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;


@Entity(name = "LoanPO")
@Table(name = "loan")
public class LoanPO {
	
	@Id
	@GeneratedValue
	@Column(name="loan_id")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_customer")
	private CustomerPO customer;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_staff")
	private StaffPO staff;
	
	private Date dateOfLoan;
	
	private Date returnDate;
	
	@ManyToMany
	@JoinTable(
		name = "loan_book",
		joinColumns = @JoinColumn(name="id_loan"),
		inverseJoinColumns = @JoinColumn(name= "id_book")
	)
	private List<BookPO> books = new ArrayList<>();
	
	
	public LoanPO(){
		
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
		return books;
	}

	public void setBooks(BookPO book) {
		this.books = books;
	}
	
	
	
}
