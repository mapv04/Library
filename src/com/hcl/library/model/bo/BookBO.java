package com.hcl.library.model.bo;

import java.util.ArrayList;
import java.util.List;

import com.hcl.library.model.po.AuthorPO;
import com.hcl.library.model.po.LoanPO;

import lombok.Builder;

@Builder
public class BookBO {
	private int id;
	private String name;
	private String edition;
	private String isbn;
	private int booksAvailable;
	private String category;
	private String language;
	private String bookcover;
	private List<AuthorPO> authors = new ArrayList<>();
	private List<LoanPO> loans = new ArrayList<>();
	
}
