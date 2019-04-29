package com.rahul.journal.service;

import java.util.List;

import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalHub;

public interface GoalRepoService 
{
	
	public void createGoalRepo(GoalHub goalRepo);
	
	public void updateGoalRepo(GoalHub goalRepo);
	
	public List<GoalHub> getAllGoalCreator();
	
	public GoalHub getAGoalCreator(String goalCreatorId);
	
	public void deleteAGoalCreator(String goalCreatorId);

}
