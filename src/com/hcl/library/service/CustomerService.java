package com.hcl.library.service;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.CustomerPO;

public class CustomerService extends GenericCrudImpl<CustomerPO> {
	private final String NAME = "customer"; 

	
	@Override
	public Class<CustomerPO> getDaoClass() {
		// TODO Auto-generated method stub
		return CustomerPO.class;
	}


	@Override
	public String getPOClassName() {
		// TODO Auto-generated method stub
		return NAME;
	}

}
