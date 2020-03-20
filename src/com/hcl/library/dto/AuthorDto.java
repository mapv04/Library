package com.hcl.library.dto;

import com.hcl.library.model.bo.AuthorBO;
import com.hcl.library.model.po.AuthorPO;

public class AuthorDto {
	
	public static final AuthorBO map(AuthorPO persistenceAuthor) {
		AuthorBO author = new AuthorBO();
		author.setId(persistenceAuthor.getId());
		author.setName(persistenceAuthor.getName());
		author.setLastName(persistenceAuthor.getLastName());
		author.setCurp(persistenceAuthor.getCurp());
		
		/* TODO
		 * author.setBooks(persistenceAuthor.getBooks());
		 */
		
		return author;
	}
	public static final AuthorPO map(AuthorBO businessAuthor) {
		AuthorPO author = new AuthorPO();
		author.setId(businessAuthor.getId());
		author.setName(businessAuthor.getName());
		author.setLastName(businessAuthor.getLastName());
		author.setCurp(businessAuthor.getCurp());
		
		/* TODO
		 * author.setBooks(businessAuthor.getBooks());
		 */
		
		return author;
	}	
}
