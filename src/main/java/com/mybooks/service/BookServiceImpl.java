package com.mybooks.service;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybooks.assembler.BookAssembler;
import com.mybooks.ds.BookDs;
import com.mybooks.dto.BookDto;
import com.mybooks.repository.BookRepository;

/**
 * Implementation of BookService interface
 * Provides methods to manipulate books objects
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	
	/*
	 * {@inheritDoc}
	 */
	@Override
	public List<BookDto> getBooks() {
		List<BookDs> bookList = bookRepository.getAll();
		return BookAssembler.ds2DtoAssembler(bookList);
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public void saveBook(BookDto dto) throws IllegalArgumentException {
		Validate.notNull(dto, "Book dto object can't be null");
		Validate.isTrue(null == dto.getId(), "Book dto can't have Id property setted");
		BookDs bookDs = BookAssembler.dto2DsAssembler(dto);
		bookRepository.save(bookDs);
		
	}

	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}	
}
