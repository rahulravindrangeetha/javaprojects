package com.rahul.journal.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.rahul.journal.entity.Journal;

public interface JournalRepo extends MongoRepository<Journal, Integer>
{

	
}
