package com.example.BookManagementSystem.service;

import java.util.List;

import com.example.BookManagementSystem.entity.Publisher;

public interface PublisherService {
    public List<Publisher> findAll();

    public Publisher findById(int theId);

    public void save(Publisher thePublisher);

    public void deleteById(int theId);
}
