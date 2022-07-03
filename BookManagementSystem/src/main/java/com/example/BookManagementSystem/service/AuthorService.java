package com.example.BookManagementSystem.service;

import java.util.List;

import com.example.BookManagementSystem.entity.Author;
import com.example.BookManagementSystem.entity.Book;

public interface AuthorService {
    public List<Author> findAll();

    public Author findById(int authorId);

    public void save(Author theAuthor);

    public void deleteById(int authorId);

    public void addBook(Author author, Book book);

}
