package com.hcl.library.model;

public class Book {
	private int id;
	private String name;
	private String edition;
	private int booksAvailable;
	private String category;
	private String language;
	private Autor autor;
	
	
	
	public Book(int id, String name, String edition, int booksAvailable, String category, String language,
			Autor autor) {
		super();
		this.id = id;
		this.name = name;
		this.edition = edition;
		this.booksAvailable = booksAvailable;
		this.category = category;
		this.language = language;
		this.autor = autor;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
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
	
	
}
