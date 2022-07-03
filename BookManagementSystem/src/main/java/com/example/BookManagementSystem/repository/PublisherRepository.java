package com.example.BookManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookManagementSystem.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
    //no need to any code
}
