package com.hcl.library;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.library.dao.BookDao;
import com.hcl.library.model.bo.AuthorBO;
import com.hcl.library.model.bo.BookBO;
import com.hcl.library.model.enums.StatusBook;
import com.hcl.library.model.po.AuthorPO;
import com.hcl.library.model.po.BookPO;
import com.hcl.library.service.AuthorService;
import com.hcl.library.service.BookService;

public class Main {

	public static void main(String[] args){
		
		/*
		AuthorBO author = new AuthorBO();
		author.setName("JRR");
		author.setLastName("Tolkien");
		author.setNacionality("British");
		author.setCurp("trrj56");
		*/
		/*
		BookBO libro = new BookBO();
		libro.setName("lord of the rings");
		libro.setIsbn("lor0001");
		libro.setCategory("fantasy");
		libro.setEditorial("flow");
		libro.setLanguage("english");
		libro.setBookcover("https://images.com/lor");
		*/
		
		
		BookBO editlibro = BookService.getInstance().findByIsbn("lor0001");
		editlibro.setEditorial("elperro");
		BookService.getInstance().updateBook(editlibro);
	}

}
