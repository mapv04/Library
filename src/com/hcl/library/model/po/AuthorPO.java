package com.hcl.library.model.po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "AuthorPO")
@Table(name = "author")
public class AuthorPO extends PersonPO {


	@ManyToMany(mappedBy = "authors")
	private List<BookPO> Books;
	
	@Column
	private String nacionality;

	public AuthorPO() {

	}
	
	public AuthorPO(String name, String lastName,  String nacionality) {
		super(name, lastName);
		this.nacionality = nacionality;
	}


	public List<BookPO> getBooks() {
		return Books;
	}

	public void setBooks(List<BookPO> books) {
		Books = books;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}
	
	

}
