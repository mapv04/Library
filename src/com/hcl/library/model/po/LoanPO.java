package com.hcl.library.model.po;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hcl.library.StatusLoan;

import lombok.Builder;


@Entity(name = "LoanPO")
@Table(name = "loan")
public class LoanPO {
	
	@Id
	@GeneratedValue
	@Column(name="loan_id")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private CustomerPO customer;

	@OneToOne(cascade=CascadeType.ALL)
	private StaffPO staff;
	//private Date dateOfLoan;
	//private Date returnDate;
	//private List<BookPO> Books;
	
	
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
	
	
	
	
	
	
}
