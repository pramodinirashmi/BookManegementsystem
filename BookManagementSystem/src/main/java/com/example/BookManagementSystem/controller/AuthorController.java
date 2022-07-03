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

import com.example.BookManagementSystem.entity.Author;
import com.example.BookManagementSystem.entity.Book;
import com.example.BookManagementSystem.exception.AuthorNotFoundException;
import com.example.BookManagementSystem.exception.BookNotFoundException;
import com.example.BookManagementSystem.service.AuthorService;

@RestController		//The RestController allows to handle all REST APIs.
@RequestMapping("/author")		//used to map web requests onto specific handler classes/methods.
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	public AuthorController(AuthorService theAuthorService) {
		this.authorService = theAuthorService;
	}

	// expose "/author" and return list of authors
	@GetMapping("/authors")		//maps HTTP GET requests onto specific handler methods.
	public List<Author> findAll() {
		return authorService.findAll();
	}

	@GetMapping("/authors/{authorId}")
	public Author findById(@PathVariable int authorId) throws AuthorNotFoundException {

		Author theAuthor = authorService.findById(authorId);

		return theAuthor;
	}

	// add mapping for POST /authors - add new author

	@PostMapping("/authors")	 //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public Author addAuthor(@Valid @RequestBody Author theAuthor) {
		theAuthor.setAuthorId(0);
		authorService.save(theAuthor);
		return theAuthor;
	}

	// add mapping for PUT /authors - update existing author

	@PutMapping("/authors")		//acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public Author updateAuthor(@Valid @RequestBody Author theAuthor) {

		authorService.save(theAuthor);

		return theAuthor;
	}

	@DeleteMapping("/authors/{authorId}")
	public String DeleteAuthor(@PathVariable int authorId) throws AuthorNotFoundException {

		authorService.deleteById(authorId);

		return "Deleted Author id - " + authorId;
	}
}
