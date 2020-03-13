package com.hcl.library.service;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.LoanPO;

public class LoanService extends GenericCrudImpl<LoanPO> {
	private final String NAME = "loan"; 

	
	@Override
	public Class<LoanPO> getDaoClass() {
		return LoanPO.class;
	}

	@Override
	public String getPOClassName() {
		return NAME;
	}

}
