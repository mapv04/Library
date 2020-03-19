package com.hcl.library.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.hcl.library.dao.AuthorDao;
import com.hcl.library.dao.BookDao;
import com.hcl.library.model.po.AuthorPO;
import com.hcl.library.model.po.BookPO;

public class BookService {
	private BookDao bookDao;
	private AuthorDao authorDao;
	private AuthorService authorService;
	
	
	public BookService() {
		bookDao = new BookDao();
		authorDao = new AuthorDao();
		authorService = new AuthorService();
	}

	public boolean createBook(BookPO book) {
		BookPO temporalBook = findByIsbn(book.getIsbn());
		if (temporalBook == null) {
			bookDao.create(book);
			return true;
		} else {
			return false;
		}
	}
	
	public void updateBook(BookPO book) {
		bookDao.update(book);
	}

	public BookPO findByName(String name) {
		return bookDao.find(bookDao.criteriaOfSearching(name,"getName"));
	}
	
	public List<BookPO> findByEditorial(String editorial) {
		return bookDao.findAll(bookDao.criteriaOfSearching(editorial, "getEditorial"));
	}
	
	public List<BookPO> findByCategory(String category) {
		return bookDao.findAll(bookDao.criteriaOfSearching(category,"getCategory"));
	}
	
	public List<BookPO> findByLanguage(String language) {
		return bookDao.findAll(bookDao.criteriaOfSearching(language, "getLanguage"));
	}
	
	public BookPO findByIsbn(String isbn) {
		return bookDao.find(bookDao.criteriaOfSearching(isbn, "getIsbn"));
	}
	
	public List<BookPO> findByAuthor(String author){
		AuthorPO temporalAuthor = authorDao.find(authorDao.criteriaOfSearching(author, "getFullName"));
		if(temporalAuthor!=null) {
			return temporalAuthor.getBooks();
		}
		return null;
	}
	

}
