package com.alex.springDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alex.springDemo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
} 
