package com.rahul.journal.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalHub;

public interface GoalRepoRepo extends MongoRepository<GoalHub, String> 
{

	@Query("{'startDate':{'$gte':?0},'endDate':{'$lte':?0},'desc':{'$nin':?1}}")
	List<GoalHub> getAllGoalCreatorForADate(LocalDate date, List<String> addedGoalDesc);

}
