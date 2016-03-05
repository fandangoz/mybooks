package com.mybooks.repository;

import java.util.List;

import com.mybooks.ds.BookDs;

/**
 * Defines persistence operations on BookDs object
 */
public interface BookRepository {
	/**
	 * Method gets all book object from database
	 * @return List of books Ds objects
	 */
	List<BookDs> getAll();
	/**
	 * Method persist book object in database
	 * @param bookDs
	 */
	void save(BookDs bookDs);
}
