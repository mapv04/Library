package com.hcl.library.service;

import java.util.List;

import com.hcl.library.dao.LoanDao;
import com.hcl.library.dto.BookDto;
import com.hcl.library.dto.LoanDTO;
import com.hcl.library.model.bo.BookBO;
import com.hcl.library.model.bo.LoanBO;
import com.hcl.library.model.enums.StatusBook;
import com.hcl.library.model.po.BookPO;
import com.hcl.library.model.po.LoanPO;

public class LoanService {
	private static LoanService loanService;
	private LoanDao loanDao;
	private BookService bookService;
	
	private LoanService() {
		this.loanDao = new LoanDao();
		this.bookService = BookService.getInstance();
	}
	
	public static LoanService getLoanService() {
		return loanService == null ? loanService = new LoanService() : loanService;
	}
	
	public boolean createLoan(LoanBO loan) {
		
		removeBooksNotAvailableToLoan(loan.getBooks());
		LoanPO newLoan = getPersistenceObject(loan);
		
		return loanDao.create(newLoan);
	}
	
	private LoanPO getPersistenceObject(LoanBO loan) {
		return LoanDTO.map(loan);
	}
	
	private List<BookBO> removeBooksNotAvailableToLoan(List<BookBO> bookList){
		for(BookBO book : bookList) {
			BookPO bookFinded = BookDto.map(bookService.findByIsbn(book.getIsbn()));
			if(bookFinded.getStatus() != StatusBook.AVAILABLE) {
				bookList.remove(book);
			}
		}
		return bookList;
	}

}
