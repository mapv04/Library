package com.hcl.library;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.library.dao.BookDao;
import com.hcl.library.model.po.AuthorPO;
import com.hcl.library.model.po.BookPO;
import com.hcl.library.service.AuthorService;
import com.hcl.library.service.BookService;

public class Main {

	public static void main(String[] args){
		
		BookService bookservice = new BookService();
		AuthorService authorservice = new AuthorService();
		BookPO book1 = new BookPO();
		AuthorPO author1 = new AuthorPO();
		/*
		author1.setName("JRR");
		author1.setLastName("Tolkien");
		book1.setName("Lord of the rings");
		book1.setIsbn("12L2");
		book1.getAuthors().add(author1);
		bookservice.createBook(book1);
		*/
		System.out.println(bookservice.findByAuthor("JRR Tolkien"));
		
	}

}
