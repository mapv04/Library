package com.hcl.library.model.po;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="StaffPO")
@Table(name="staff")
public class StaffPO extends PersonPO{
	
	private String username;

	private String password;
	
	@OneToOne(mappedBy = "staff")
	@JoinColumn(name="staff_id")
	private LoanPO loan;

}
