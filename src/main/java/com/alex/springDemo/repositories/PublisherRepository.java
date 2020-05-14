package com.alex.springDemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alex.springDemo.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}
