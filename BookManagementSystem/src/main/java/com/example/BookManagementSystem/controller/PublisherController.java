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

import com.example.BookManagementSystem.entity.Publisher;
import com.example.BookManagementSystem.exception.PublisherNotFoundException;
import com.example.BookManagementSystem.service.PublisherService;

@RestController // The RestController allows to handle all REST APIs.
@RequestMapping("/publisher") // used to map web requests onto specific handler classes/methods.
public class PublisherController {
	@Autowired
	private PublisherService publisherService;

	public PublisherController(PublisherService thePublisherService) {
		this.publisherService = thePublisherService;
	}

	@GetMapping("/publishers") // maps HTTP GET requests onto specific handler methods.
	public List<Publisher> findAll() {
		return publisherService.findAll();
	}

	@GetMapping("/publishers/{theId}")
	public Publisher findById(@PathVariable int theId) throws PublisherNotFoundException {

		Publisher publisher = publisherService.findById(theId);

		return publisher;
	}

	// add mapping for POST /publishers - add new publisher

	@PostMapping("/publishers") // acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public Publisher addPublisher(@Valid @RequestBody Publisher thePublisher) {
		thePublisher.setPublisherId(0);
		publisherService.save(thePublisher);
		return thePublisher;
	}

	// add mapping for PUT /publishers - update existing publisher

	@PutMapping("/publishers") // acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public Publisher updatePublisher(@Valid @RequestBody Publisher thePublisher) {

		publisherService.save(thePublisher);

		return thePublisher;
	}

	// add mapping for DELETE /publishers/{theId} - delete publisher

	@DeleteMapping("/publishers/{theId}")
	public String DeletePublisher(@PathVariable int theId) throws PublisherNotFoundException {

		publisherService.deleteById(theId);

		return "Deleted Publisher id - " + theId;
	}

}
