package com.hcl.library.service;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.StaffPO;

public class StaffService extends GenericCrudImpl<StaffPO>{
	private final String NAME = "staff"; 

	
	@Override
	public Class<StaffPO> getDaoClass() {
		return StaffPO.class;
	}

	@Override
	public String getPOClassName() {
		return NAME;
	}
	
	
}
