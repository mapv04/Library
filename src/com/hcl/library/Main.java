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
		
		AuthorBO AUTHOR = new AuthorBO();
		
		AUTHOR.setName("perro");
		
		
		BookBO LIBRO1= new BookBO();
		LIBRO1.getAuthors().add(AUTHOR);
		LIBRO1.setName("HOLA");
		
		System.out.println(LIBRO1);
	}

}
