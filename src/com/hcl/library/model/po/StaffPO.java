package com.hcl.library.model.po;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="StaffPO")
@Table(name="staff")
public class StaffPO extends PersonPO{
	
	private String username;
	
	private String password;
	
	@OneToOne(mappedBy = "staff")
	@JoinColumn(name="staff_id")
	private LoanPO loan;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoanPO getLoan() {
		return loan;
	}
	public void setLoan(LoanPO loan) {
		this.loan = loan;
	}

}
