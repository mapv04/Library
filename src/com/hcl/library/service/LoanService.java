package com.hcl.library.service;

import java.util.List;

import com.hcl.library.dao.LoanDao;
import com.hcl.library.model.bo.BookBO;
import com.hcl.library.model.bo.LoanBO;
import com.hcl.library.model.enums.StatusBook;
import com.hcl.library.model.po.BookPO;
import com.hcl.library.model.po.LoanPO;
import com.hcl.library.model.utils.TransformDataUtils;

public class LoanService {
	private LoanDao loanDao = new LoanDao();
	private BookService bookService = new BookService();
	
	public boolean createLoan(LoanBO loan) {
		List<BookBO> bookList = loan.getBooks();
		for(BookBO book : bookList) {
			BookPO bookFinded = bookService.findByIsbn(book.getIsbn());
			if(bookFinded.getStatus() != StatusBook.AVAILABLE) {
				bookList.remove(book);
			}
		}
		
		LoanPO newLoan = TransformDataUtils.map(loan);
		
		return loanDao.create(newLoan);
	}

}
