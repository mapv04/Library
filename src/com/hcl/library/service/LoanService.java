package com.hcl.library.service;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.LoanPO;

public class LoanService extends GenericCrudImpl<LoanPO> {

	@Override
	public Class<LoanPO> getDaoClass() {
		// TODO Auto-generated method stub
		return LoanPO.class;
	}

}
