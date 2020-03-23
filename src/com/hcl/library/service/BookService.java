package com.hcl.library.service;

import java.util.List;

import com.hcl.library.dao.AuthorDao;
import com.hcl.library.dao.BookDao;
import com.hcl.library.dto.BookDto;
import com.hcl.library.model.bo.BookBO;
import com.hcl.library.model.po.AuthorPO;
import com.hcl.library.model.po.BookPO;

public class BookService {
	private BookDao bookDao;
	private AuthorDao authorDao;
	
	
	public BookService() {
		bookDao = new BookDao();
		authorDao = new AuthorDao();
	}

	public boolean createBook(BookBO book) {
		BookPO persistenceBook=getPersistenceBook(book);
		BookBO bookFound = findByIsbn(persistenceBook.getIsbn());
		if (bookFound == null) {
			bookDao.create(persistenceBook);
			return true;
		} else {
			return false;
		}
	}
	
	public void updateBook(BookBO book) {
		BookPO persistenceBook=getPersistenceBook(book);
		bookDao.update(persistenceBook);
	}

	public BookBO findByName(String name) {
		BookPO bookFound=bookDao.find(bookDao.criteriaOfSearching(name,"getName"));
		return getBusinessBook(bookFound);
	}
	
	public BookBO findByIsbn(String isbn) {
		BookPO bookFound=bookDao.find(bookDao.criteriaOfSearching(isbn, "getIsbn"));
		return getBusinessBook(bookFound);
	}
	
	public List<BookBO> findByEdition(String edition) {
		List<BookPO> booksFound=bookDao.findAll(bookDao.criteriaOfSearching(edition, "getEdition"));
		return getBusinessList(booksFound);
	}
	
	public List<BookBO> findByEditorial(String editorial) {
		List<BookPO> booksFound=bookDao.findAll(bookDao.criteriaOfSearching(editorial, "getEditorial"));
		return getBusinessList(booksFound);
	}
	
	public List<BookBO> findByCategory(String category) {
		List<BookPO> booksFound=bookDao.findAll(bookDao.criteriaOfSearching(category,"getCategory"));
		return getBusinessList(booksFound);
	}
	
	public List<BookBO> findByLanguage(String language) {
		List<BookPO> booksFound= bookDao.findAll(bookDao.criteriaOfSearching(language, "getLanguage"));
		return getBusinessList(booksFound);
	}
	
	public List<BookBO> findByAuthor(String author){
		AuthorPO authorFound = authorDao.find(authorDao.criteriaOfSearching(author, "getFullName"));
		if(authorFound!=null) {
			return getBusinessList(authorFound.getBooks());
		}
		return null;
	}
	
	private BookPO getPersistenceBook(BookBO book) {
		return BookDto.map(book);
	}
	
	private List<BookBO> getBusinessList(List<BookPO> books) {
		return BookDto.mapBookListToBO(books);
	}
	
	private BookBO getBusinessBook(BookPO book) {
		return BookDto.map(book);
	}

}
