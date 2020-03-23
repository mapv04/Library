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
		BookPO persistenceBook=getPersistenceObject(book);
		BookBO bookFound = findByIsbn(persistenceBook.getIsbn());
		if (bookFound == null) {
			bookDao.create(persistenceBook);
			return true;
		} else {
			return false;
		}
	}
	
	public void updateBook(BookBO book) {
		BookPO persistenceBook=getPersistenceObject(book);
		bookDao.update(persistenceBook);
	}

	public BookBO findByName(String name) {
		BookPO bookFound=bookDao.find(bookDao.criteriaOfSearching(name,"getName"));
		return getBusinessObject(bookFound);
	}
	
	public BookBO findByIsbn(String isbn) {
		BookPO bookFound=bookDao.find(bookDao.criteriaOfSearching(isbn, "getIsbn"));
		return getBusinessObject(bookFound);
	}
	
	public List<BookBO> findByEdition(String edition) {
		List<BookPO> booksFound=bookDao.findAll(bookDao.criteriaOfSearching(edition, "getEdition"));
		return getBusinessList(booksFound);
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
	
	
	
	public List<BookPO> findByAuthor(String author){
		AuthorPO temporalAuthor = authorDao.find(authorDao.criteriaOfSearching(author, "getFullName"));
		if(temporalAuthor!=null) {
			return temporalAuthor.getBooks();
		}
		return null;
	}
	
	private BookPO getPersistenceObject(BookBO book) {
		return BookDto.map(book);
	}
	
	private List<BookBO> getBusinessList(List<BookPO> books) {
		return BookDto.mapBookListToBO(books);
	}
	
	private BookBO getBusinessObject(BookPO book) {
		return BookDto.map(book);
	}

}
