package com.hcl.library.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.hcl.library.dao.AuthorDao;
import com.hcl.library.dao.BookDao;
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
		BookPO temporalBook = findByName(book.getName());
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
		String bookNameFormatted = name.replace(" ", "").toLowerCase();
		Predicate<BookPO> sameBookName = bookName -> bookName.getName().replace(" ", "").toLowerCase()
				.equals(bookNameFormatted);
		return bookDao.find(sameBookName);
	}
	
	public List<BookPO> findByEditorial(String editorial) {
		String bookNameFormatted = editorial.replace(" ", "").toLowerCase();
		Predicate<BookPO> sameEditorialName = bookEditorial -> bookEditorial.getEditorial().replace(" ", "").toLowerCase()
				.equals(bookNameFormatted);
		return bookDao.findAll(sameEditorialName);
	}
	
	public List<BookPO> findByCategory(String category) {
		String bookNameFormatted = category.replace(" ", "").toLowerCase();		
		Predicate<BookPO> sameCategoryName = bookCategory -> bookCategory.getCategory().replace(" ", "").toLowerCase()
				.equals(bookNameFormatted);
		return bookDao.findAll(sameCategoryName);
	}
	
	public List<BookPO> findByLanguage(String language) {
		String bookNameFormatted = language.replace(" ", "").toLowerCase();		
		Predicate<BookPO> sameLanguageName = bookCategory -> bookCategory.getLanguage().replace(" ", "").toLowerCase()
				.equals(bookNameFormatted);
		return bookDao.findAll(sameLanguageName);
	}

	
	
	

}
