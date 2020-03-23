package com.hcl.library.service;

import java.util.List;

import com.hcl.library.dao.AuthorDao;
import com.hcl.library.dto.AuthorDto;
import com.hcl.library.model.bo.AuthorBO;
import com.hcl.library.model.po.AuthorPO;

public class AuthorService {
	private AuthorDao authorDao;
	
	public AuthorService() {
		authorDao = new AuthorDao();
	}
	
	public boolean createBook(AuthorBO author) {
		AuthorPO persistenceAuthor=getPersistenceAuthor(author);
		AuthorBO authorFound = findByName(persistenceAuthor.getFullName());
		if (authorFound == null) {
			authorDao.create(persistenceAuthor);
			return true;
		} else {
			return false;
		}
	}
	
	public AuthorBO findById(int id) {
		AuthorPO authorFound=authorDao.findById(id);
		return getBusinessAuthor(authorFound);
	}
	
	public AuthorBO findByName(String fullName) {
		AuthorPO authorFound=authorDao.find(authorDao.criteriaOfSearching(fullName, "getFullName"));
		return getBusinessAuthor(authorFound);
	}
	
	public List<AuthorBO> findByNacionality(String nacionality) {
		List<AuthorPO> authorsFound=authorDao.findAll(authorDao.criteriaOfSearching(nacionality, "getNacionality"));
		return getBusinessList(authorsFound);
	}
	
	private AuthorPO getPersistenceAuthor(AuthorBO author) {
		return AuthorDto.map(author);
	}
	
	private AuthorBO getBusinessAuthor(AuthorPO author) {
		return AuthorDto.map(author);
	}
	
	private List<AuthorBO> getBusinessList(List<AuthorPO> authors) {
		return AuthorDto.mapAuthorListToBO(authors);
	}

}
