package com.hcl.library.model.po;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;

@Entity(name="book")
public class BookPO {
	@Id
	private int id;
	private String name;
	private String edition;
	private int booksAvailable;
	private String category;
	private String language;
	private AuthorPO author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public int getBooksAvailable() {
		return booksAvailable;
	}
	public void setBooksAvailable(int booksAvailable) {
		this.booksAvailable = booksAvailable;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public AuthorPO getAuthor() {
		return author;
	}
	public void setAuthor(AuthorPO author) {
		this.author = author;
	}
	
	
	
}
