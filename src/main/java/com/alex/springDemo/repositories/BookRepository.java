package com.alex.springDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alex.springDemo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
