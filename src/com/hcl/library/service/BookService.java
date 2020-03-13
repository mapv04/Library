package com.hcl.library.service;

import java.util.List;

import com.hcl.library.generics.GenericCrudImpl;
import com.hcl.library.model.po.AuthorPO;
import com.hcl.library.model.po.BookPO;

public class BookService extends GenericCrudImpl<BookPO>{
	
	
	public void addAuthors(BookPO tarjet, List<AuthorPO> authors) {
		tarjet.setAuthors(authors);
	}
	
	
	public Class<BookPO> getDaoClass() {
		return BookPO.class;
	}

}
