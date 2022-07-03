package com.example.BookManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookManagementSystem.entity.Book;
import com.example.BookManagementSystem.exception.BookNotFoundException;
import com.example.BookManagementSystem.service.BookService;

@RestController // The RestController allows to handle all REST APIs.
@RequestMapping("/api") // used to map web requests onto specific handler classes/methods.
public class BookController {
	@Autowired
	private BookService bookService;

	public BookController(BookService theBookService) {
		this.bookService = theBookService;
	}

	// expose "/books" and return list of books
	@GetMapping("/books") // maps HTTP GET requests onto specific handler methods.
	public List<Book> findAll() {
		return bookService.findAll();
	}

	// add mapping for GET /books/{bookId}
	@GetMapping("/books/{bookId}") // acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public Book getBook(@PathVariable int bookId) throws BookNotFoundException {

		Book thebook = bookService.findById(bookId);

		return thebook;
	}

	// add mapping for POST /books - add new book

	@PostMapping("/books") // acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public Book addBook(@Valid @RequestBody Book thebook) {
		thebook.setBookId(0);
		bookService.save(thebook);
		return thebook;
	}

	// add mapping for PUT /books - update existing book

	@PutMapping("/books")
	public Book updateBook(@Valid @RequestBody Book thebook) {

		bookService.save(thebook);

		return thebook;
	}

	// add mapping for DELETE /books/{bookId} - delete book

	@DeleteMapping("/books/{bookId}")
	public String DeleteBook(@PathVariable int bookId) throws BookNotFoundException {

		bookService.deleteById(bookId);

		return "Deleted Book id - " + bookId;
	}

	@GetMapping("/search")
	public List<Book> findBookByName(@PathVariable("keyword") String keyword) {
		List<Book> thebook = bookService.findBookByName(keyword);
		return thebook;
	}
}
