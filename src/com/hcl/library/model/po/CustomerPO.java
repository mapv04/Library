package com.hcl.library.model.po;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "CustomerPO")
@Table(name = "customer")
public class CustomerPO extends PersonPO{
	
	@Column
	private boolean status;
	
	@OneToOne(cascade=CascadeType.ALL)
	private AddressPO address;
	
	@Column
	private Date birthday;
	
	@OneToOne(mappedBy = "customer")
	private LoanPO loan;
	
	@Column
	private String email;

	@Column
	private String phone;
	
	public CustomerPO() {
		
	}
	
	public LoanPO getLoan() {
		return loan;
	}

	public void setLoan(LoanPO loan) {
		this.loan = loan;
	}

	public AddressPO getAddress() {
		return address;
	}

	public void setAddress(AddressPO address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
