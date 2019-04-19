package com.rahul.journal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rahul.journal.entity.Goal;

public interface GoalRepo extends MongoRepository<Goal, String> {

}
