package com.example.BookManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookManagementSystem.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    //no need to any code
}
