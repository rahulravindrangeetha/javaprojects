package com.rahul.journal.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rahul.journal.entity.Goal;

public interface GoalRepo extends MongoRepository<Goal, String> 
{

	@Query("{'startDate':{'$gte':?0},'expectedEndDate':{'$lte':?0}}")
	List<Goal> fetchGoals(LocalDate date);

}
