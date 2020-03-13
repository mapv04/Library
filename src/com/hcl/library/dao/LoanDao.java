package com.hcl.library.dao;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.LoanPO;

public class LoanDao extends GenericCrudImpl<LoanPO> {
	
	public LoanDao(Class<LoanPO> name) {
		super(name);
	}

	

}
