package com.hcl.library.model.bo;

import java.util.ArrayList;
import java.util.List;

import com.hcl.library.model.enums.StatusBook;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookBO {
	private int id;
	private String name;
	private String edition;
	private String isbn;
	private String category;
	private String language;
	private String bookcover;
	private List<AuthorBO> authors = new ArrayList<>();
	private List<LoanBO> loans = new ArrayList<>();
	private StatusBook status;
	
}
