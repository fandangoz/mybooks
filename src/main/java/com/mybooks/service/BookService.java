package com.mybooks.service;

import java.util.List;

import com.mybooks.dto.BookDto;

/**
 * Interface defines operations on books objects
 */
public interface BookService {
	/**
	 * Return list containing Book Data Trasnsfer Objects
	 * @return List of books
	 */
	List<BookDto> getBooks();

	/**
	 * Method transform book Data Transfer Object into Data Source Object and persist it
	 * @param dto book transfer object
	 * @throws IllegalArgumentException when book dto is null or have Id property seted
	 */
	void saveBook(BookDto dto) throws IllegalArgumentException;
}
