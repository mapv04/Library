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

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity(name = "LoanPO")
@Table(name = "loan")
public class LoanPO {
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
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

	
	
	
	
}
