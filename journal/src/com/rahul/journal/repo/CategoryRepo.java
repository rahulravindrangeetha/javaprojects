package com.rahul.journal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rahul.journal.entity.Category;

public interface CategoryRepo extends MongoRepository<Category, String> 
{

}
