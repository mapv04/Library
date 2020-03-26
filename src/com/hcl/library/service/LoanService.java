package com.hcl.library.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		boolean isCreated = false;
		if (!loanHasNulls(loan)) {
			loan.setBooks(removeBooksNotAvailableToLoan(loan.getBooks()));
			if (loan.getBooks().size() > 0) {
				LoanPO newLoan = getPersistenceObject(loan);
				isCreated = loanDao.create(newLoan);
				loanBooks(loan.getBooks());
			}
		}
		return isCreated;
	}

	private LoanPO getPersistenceObject(LoanBO loan) {
		return LoanDTO.map(loan);
	}

	private List<BookBO> removeBooksNotAvailableToLoan(List<BookBO> bookList) {
		return bookList.stream()
				.map(book -> bookService.findByIsbn(book.getIsbn()))
				.filter(book -> BookDto.map(bookService.findByIsbn(book.getIsbn())).getStatus() == StatusBook.AVAILABLE)
				.collect(Collectors.toList());
	}

	private boolean loanHasNulls(LoanBO loan) {
		return Stream
				.of(loan.getStaff(), loan.getCustomer(), loan.getDateOfLoan(), loan.getReturnDate(), loan.getBooks())
				.anyMatch(x -> x == null);
	}

	private void loanBooks(List<BookBO> books) {
		for (BookBO book : books) {
			book.setStatus(StatusBook.LOANED);
			bookService.updateBook(book);
		}
	}

}
