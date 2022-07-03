package com.example.BookManagementSystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagementSystem.entity.Author;
import com.example.BookManagementSystem.entity.Book;
import com.example.BookManagementSystem.exception.AuthorNotFoundException;
import com.example.BookManagementSystem.exception.BookNotFoundException;
import com.example.BookManagementSystem.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository thebBookRepository) {
		super();
		this.bookRepository = thebBookRepository;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int bookId) {
		// TODO Auto-generated method stub
		Optional<Book> result = bookRepository.findById(bookId);
		
		Book thebook = null;
		
		if(result.isPresent()) {
			thebook = result.get();
		}
		else {
			//we didn't find the book
			throw new BookNotFoundException("Did not find book id - " + bookId);
		}
		return thebook;
	}
	
	@Override
	public void save(Book thebook) {
		// TODO Auto-generated method stub
		bookRepository.save(thebook);
	}

	@Override
	public void deleteById(int bookId) {
		// TODO Auto-generated method stub
		Optional<Book> thebook = bookRepository.findById(bookId);
		if(thebook == null) {
			throw new BookNotFoundException("Book id not found - " + bookId);
		}
		bookRepository.deleteById(bookId);
	}

	@Override
	public List<Book> findBookByName(String keyword) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookName(keyword);
	}
}
