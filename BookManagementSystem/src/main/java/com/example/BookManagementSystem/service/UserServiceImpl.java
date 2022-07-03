package com.example.BookManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagementSystem.entity.User;
import com.example.BookManagementSystem.exception.UserNotFoundException;
import com.example.BookManagementSystem.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

    public UserServiceImpl(UserRepository theUserRepository) {
	this.userRepository = theUserRepository;
  }

	public void save(User user) {
		userRepository.save(user);
	}
	
	public User findById(long userId) {
		Optional<User> result = userRepository.findById(userId);
		
		User users = null;
		
		if(result.isPresent()) {
			users = result.get();
		}
		else {
			//we didn't find the book
			throw new UserNotFoundException("Did not find User id - " + userId);
		}
		return users;
	}	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public List<User> userSearcher(String firstName, String lastName){
		if (firstName != null && lastName != null) return getByFullName(firstName, lastName);
		else if (firstName == null && lastName != null) return getByLastName(lastName);
		else if (firstName != null && lastName == null) return getByFirstName(firstName);
		else return new ArrayList<User>();
	}
	
	public List<User> getByFirstName(String firstName){
		List<User> users = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			if (user.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
				users.add(user);
			}
		}
		return users;
	}
	
	public List<User> getByLastName(String lastName){
		List<User> users = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			if(user.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
				users.add(user);
			}
		}
		return users;
	}
	
	public List<User> getByFullName(String firstName, String lastName){
		List<User> users = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			if (user.getFirstName().toLowerCase().contains(firstName.toLowerCase()) &&
				user.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
				users.add(user);
			}
		}
		return users;
	}

	@Override
	public void deleteById(long userId) {
		// TODO Auto-generated method stub
		Optional<User> theUser = userRepository.findById(userId);
		if(theUser == null) {
			throw new UserNotFoundException("User id not found - " + userId);
		}
		userRepository.deleteById(userId);
	}
 }
	   
