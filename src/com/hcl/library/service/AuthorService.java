package com.hcl.library.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.hibernate.loader.criteria.CriteriaLoader;

import com.hcl.library.dao.AuthorDao;
import com.hcl.library.model.po.AuthorPO;
import com.hcl.library.model.po.BookPO;

public class AuthorService {
	private AuthorDao authorDao;
	
	public AuthorService() {
		authorDao = new AuthorDao();
	}
	
	public boolean createBook(AuthorPO author) {
		AuthorPO temporalAuthor = findByName(author.getFullName());
		if (temporalAuthor == null) {
			authorDao.create(author);
			return true;
		} else {
			return false;
		}
	}
	
	public AuthorPO findById(int id) {
		return authorDao.findById(id);
	}
	
	public AuthorPO findByName(String fullName) {
		return authorDao.find(authorDao.criteriaOfSearching(fullName, "getFullName"));
	}
	
	public List<AuthorPO> findByNacionality(String nacionality) {
		return authorDao.findAll(authorDao.criteriaOfSearching(nacionality, "getNacionality"));
	}
   
}
