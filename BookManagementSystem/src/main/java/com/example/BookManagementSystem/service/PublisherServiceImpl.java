package com.example.BookManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagementSystem.entity.Book;
import com.example.BookManagementSystem.entity.Publisher;
import com.example.BookManagementSystem.exception.AuthorNotFoundException;
import com.example.BookManagementSystem.exception.PublisherNotFoundException;
import com.example.BookManagementSystem.repository.PublisherRepository;
@Service
public class PublisherServiceImpl implements PublisherService{
	private PublisherRepository publisherRepository;
	
	@Autowired
    public PublisherServiceImpl(PublisherRepository thePublisherRepository) {
        this.publisherRepository = thePublisherRepository;
    }
	@Override
	public List<Publisher> findAll() {
		// TODO Auto-generated method stub
		 return publisherRepository.findAll();
	}

	@Override
	public Publisher findById(int theId) {
		Optional<Publisher> result = publisherRepository.findById(theId);

        Publisher thePublisher = null;

        if (result.isPresent()) {
            thePublisher = result.get();
        }
        else {
            // we didn't find the publisher
            throw new PublisherNotFoundException("Did not find publisher id - " + theId);
        }

        return thePublisher;
	}

	@Override
	public void save(Publisher thePublisher) {
		// TODO Auto-generated method stub
		publisherRepository.save(thePublisher);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Optional<Publisher> thePublisher = publisherRepository.findById(theId);
		if(thePublisher == null) {
			throw new PublisherNotFoundException("Publisher id not found - " + theId);
		}
		publisherRepository.deleteById(theId);
	}

}
