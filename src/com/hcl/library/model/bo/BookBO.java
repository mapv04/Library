package com.hcl.library.model.bo;

import lombok.Builder;

@Builder
public class BookBO {
	private int id;
	private String name;
	private String edition;
	private int booksAvailable;
	private String category;
	private String language;
	private AuthorBO author;
	
	
	
}
