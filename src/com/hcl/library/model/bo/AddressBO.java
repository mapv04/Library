package com.hcl.library.model.bo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressBO {
	private int number;
	private String street;
	private String city;
	private String state;
	private String country;
	private int postalCode;


	
}
