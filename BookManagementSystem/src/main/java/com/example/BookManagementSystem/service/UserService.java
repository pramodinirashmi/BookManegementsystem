package com.example.BookManagementSystem.service;
import java.util.List;

import com.example.BookManagementSystem.entity.User;


public interface UserService {
	public List<User> findAll();
	
	public User findById(long userId);
	
	public void save(User user);
	
	public void deleteById(long userId);
	
	public List<User> getByFullName(String firstName, String lastName);
	
	public List<User> getByFirstName(String firstName);
	
	public List<User> getByLastName(String lastName);
	
	public List<User> userSearcher(String firstName, String lastName);
	
}
