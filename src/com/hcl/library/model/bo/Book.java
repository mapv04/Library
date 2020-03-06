package com.hcl.library.model.bo;

import lombok.Builder;

@Builder
public class Book {
	private int id;
	private String name;
	private String edition;
	private int booksAvailable;
	private String category;
	private String language;
	private Author author;
	
	
	
}
