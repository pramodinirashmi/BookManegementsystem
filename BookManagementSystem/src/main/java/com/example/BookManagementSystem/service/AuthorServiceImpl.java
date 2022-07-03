package com.example.BookManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagementSystem.entity.Author;
import com.example.BookManagementSystem.entity.Book;
import com.example.BookManagementSystem.entity.User;
import com.example.BookManagementSystem.exception.AuthorNotFoundException;
import com.example.BookManagementSystem.exception.UserNotFoundException;
import com.example.BookManagementSystem.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorServiceImpl(AuthorRepository theAuthorRepository) {
		super();
		this.authorRepository = theAuthorRepository;
	}

	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		 return authorRepository.findAll();
	}

	@Override
	public Author findById(int authorId) {
		// TODO Auto-generated method stub
		Optional<Author> result = authorRepository.findById(authorId);
        Author theAuthor = null;
        if (result.isPresent()) {
            theAuthor = result.get();
        }
        else {
            // we didn't find the Author
            throw new AuthorNotFoundException("Did not find author id - " + authorId);
        }
        return theAuthor;
    }

	@Override
	public void save(Author theAuthor) {
		// TODO Auto-generated method stub
		authorRepository.save(theAuthor);
	}

	@Override
	public void deleteById(int authorId) {
		// TODO Auto-generated method stub
		Optional<Author> theAuthor = authorRepository.findById(authorId);
		if(theAuthor == null) {
			throw new AuthorNotFoundException("Author id not found - " + authorId);
		}
		authorRepository.deleteById(authorId);
	}

	@Override
	public void addBook(Author author, Book book) {
		// TODO Auto-generated method stub
		 if( authorRepository.findById(author.getAuthorId()).isPresent())
	         authorRepository.findById(author.getAuthorId()).get().getBooksList().add(book);
	}

}
