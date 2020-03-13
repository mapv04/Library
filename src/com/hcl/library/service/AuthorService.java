package com.hcl.library.service;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.AuthorPO;

public class AuthorService extends GenericCrudImpl<AuthorPO>{

	@Override
	public Class<AuthorPO> getDaoClass() {
		// TODO Auto-generated method stub
		return AuthorPO.class;
	} 
	

}
