package com.hcl.library.dao;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.CustomerPO;

public class CustomerDao extends GenericCrudImpl<CustomerPO> {
	
	public CustomerDao() {
		super(CustomerPO.class);
	}




}
