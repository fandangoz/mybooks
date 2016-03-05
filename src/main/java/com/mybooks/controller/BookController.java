package com.mybooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybooks.dto.BookDto;
import com.mybooks.service.BookService;

/**
 * Provides rest methods to manipulate books object
 * Communication between GUI and this controller uses JSON
 */
@RestController
@RequestMapping("/books")
public class BookController {
	private BookService bookService;
	
	/**
	 * Method maps list of books returned from service into JSON list  
	 * @return JSON list of books
	 */
	@RequestMapping(value= "/getAllBooks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookDto> getBooks() {
		return bookService.getBooks();
	}
	
	/**
	 * Saves book object obtained via POST request
	 * @param book JSON object containing book properties
	 */
	@RequestMapping(value= "/addBook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveBook(@RequestBody BookDto book) {
		bookService.saveBook(book);
	}

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}	
}
