package com.hcl.library.model;

import java.util.Date;

import lombok.Data;

@Data
public class Customer extends Person{
	
	private boolean status;
	private Address address;
	private Date birthday;
	

	
}
