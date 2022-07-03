package com.example.BookManagementSystem.service;

import java.util.List;

import com.example.BookManagementSystem.entity.Book;

public interface BookService {
public List<Book> findAll();
	
	public Book findById(int bookId);

	public void save(Book thebook);
	
	public void deleteById(int bookId);
	
	List<Book> findBookByName(String keyword);
}
