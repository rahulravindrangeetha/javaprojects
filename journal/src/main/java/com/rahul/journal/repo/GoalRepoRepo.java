package com.rahul.journal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalCreator;

public interface GoalRepoRepo extends MongoRepository<GoalCreator, String> {

}
