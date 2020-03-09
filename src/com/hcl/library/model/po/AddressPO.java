package com.hcl.library.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "AddressPO")
@Table(name = "address")
public class AddressPO {
	
	@Id
	private int id;
	 
	private int number;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int postalCode;
	
	@OneToOne(mappedBy = "address")
	@JoinColumn(name="address_id")
	private CustomerPO customer;
	
	public AddressPO() {
			
	}

	public AddressPO(int number, String street, String city, String state, String country, int postalCode) {
		super();
		this.number = number;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	public CustomerPO getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerPO customer) {
		this.customer = customer;
	}
	
	
	
	
	
}
