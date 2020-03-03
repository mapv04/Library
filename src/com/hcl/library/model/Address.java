package com.hcl.library.model;

import lombok.Builder;

@Builder
public class Address {
	private int number;
	private String street;
	private String city;
	private String state;
	private String country;
	private int postalCode;

	
}
