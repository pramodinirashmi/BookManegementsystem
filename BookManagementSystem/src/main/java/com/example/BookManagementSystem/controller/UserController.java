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

import com.example.BookManagementSystem.entity.User;
import com.example.BookManagementSystem.exception.UserNotFoundException;
import com.example.BookManagementSystem.service.UserService;

@RestController // The RestController allows to handle all REST APIs
@RequestMapping("/user") // used to map web requests onto specific handler classes/methods.
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/users") // maps HTTP GET requests onto specific handler methods.
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{userId}")
	public User findById(@PathVariable long userId) throws UserNotFoundException {

		User user = userService.findById(userId);

		return user;
	}

	// add mapping for POST /users - add new user

	@PostMapping("/users") // acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public User addUser(@Valid @RequestBody User theUser) {
		theUser.setUserId(0);
		userService.save(theUser);
		return theUser;
	}

	// add mapping for PUT /users - update existing user

	@PutMapping("/users") // acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public User updateUser(@Valid @RequestBody User theUser) {

		userService.save(theUser);

		return theUser;
	}

	// add mapping for DELETE /users/{userId} - delete user

	@DeleteMapping("/users/{userId}")
	public String DeleteUser(@PathVariable long userId) throws UserNotFoundException {
		userService.deleteById(userId);

		return "Deleted User id - " + userId;
	}

}
