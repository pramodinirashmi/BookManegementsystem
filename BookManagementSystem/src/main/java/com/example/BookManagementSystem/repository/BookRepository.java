package com.example.BookManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookManagementSystem.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book , Integer> {
	List<Book> findByBookName(String keyword);
}
