package com.rahul.journal.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rahul.journal.entity.Journal;

public interface JournalRepo extends MongoRepository<Journal, String>
{
	@Query("{'date':?0}")
	public Journal findByDate(LocalDate date);

	
}
