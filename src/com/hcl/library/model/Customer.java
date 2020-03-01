package com.hcl.library.model;

import java.util.Date;

public class Customer extends Person{
	public Customer(int id, String name, String lastName) {
		super(id, name, lastName);
		// TODO Auto-generated constructor stub
	}
	private boolean status;
	private Address address;
	private Date birthday;
	

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
