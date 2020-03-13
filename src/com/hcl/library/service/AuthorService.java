package com.hcl.library.service;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.AuthorPO;

public class AuthorService extends GenericCrudImpl<AuthorPO>{
	private final String NAME = "autor"; 
	
	@Override
	public Class<AuthorPO> getDaoClass() {
		return AuthorPO.class;
	}

	@Override
	public String getPOClassName() {
		return NAME;
	} 
	

}
