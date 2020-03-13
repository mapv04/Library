package com.hcl.library.service;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.StaffPO;

public class StaffService extends GenericCrudImpl<StaffPO>{

	@Override
	public Class<StaffPO> getDaoClass() {
		// TODO Auto-generated method stub
		return StaffPO.class;
	}

}
