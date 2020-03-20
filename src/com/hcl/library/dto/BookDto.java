package com.hcl.library.dto;

import com.hcl.library.model.bo.BookBO;
import com.hcl.library.model.po.BookPO;

public class BookDto {
	public static final BookBO map(BookPO persistenceBook) {
		BookBO book = new BookBO();
		book.setId(persistenceBook.getId());
		book.setName(persistenceBook.getName());
		book.setIsbn(persistenceBook.getIsbn());
		book.setEdition(persistenceBook.getEdition());
		book.setEditorial(persistenceBook.getEditorial());
		book.setCategory(persistenceBook.getCategory());
		book.setLanguage(persistenceBook.getLanguage());
		book.setBookcover(persistenceBook.getBookcover());
		book.setStatus(persistenceBook.getStatus());
		/*TODO 
			book.setAuthors(persistenceBook.getAuthors());
			book.setLoans(persistenceBook.getLoans());  
		*/
		
		return book;
	}
	
	public static final BookPO map(BookBO businessBook) {
		BookPO book = new BookPO();
		book.setId(businessBook.getId());
		book.setName(businessBook.getName());
		book.setEdition(businessBook.getEdition());
		book.setEditorial(businessBook.getEdition());
		book.setIsbn(businessBook.getIsbn());
		book.setCategory(businessBook.getCategory());
		book.setLanguage(businessBook.getLanguage());
		book.setBookcover(businessBook.getBookcover());
		book.setStatus(businessBook.getStatus());
		/* TODO
			book.setAuthors(businessBook.getAuthors());
			book.setLoans(businessBook.getLoans());
		*/
		return book;
	}
}
