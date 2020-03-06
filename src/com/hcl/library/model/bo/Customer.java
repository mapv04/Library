package com.hcl.library.model.bo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer extends Person{
	
	private boolean status;
	private Address address;
	private Date birthday;
	

	
}
