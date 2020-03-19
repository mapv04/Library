package com.hcl.library.service;

import java.util.Optional;
import java.util.function.Predicate;

import com.hcl.library.dao.AuthorDao;
import com.hcl.library.model.po.AuthorPO;
import com.hcl.library.model.po.BookPO;

public class AuthorService {
	private AuthorDao authordao;
	
	public AuthorService() {
		authordao = new AuthorDao();
	}
	
	public boolean createAuthor(AuthorPO author) {
		String name = author.getName();
		Predicate<AuthorPO> sameName = authorName -> authorName.getName().equals(name);
        Optional<AuthorPO> isAuthorPresent = authordao.findAll().stream().filter(sameName).findAny(); 
		
        if(isAuthorPresent.isPresent()) {
        	System.out.println("Error , author already exist");

        	return false;

        }else {
        	authordao.create(author);
    		return true;

        }
	}
}
