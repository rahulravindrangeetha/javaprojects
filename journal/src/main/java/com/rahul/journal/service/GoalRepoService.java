package com.rahul.journal.service;

import java.util.List;

import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalCreator;

public interface GoalRepoService 
{
	
	public void createGoalRepo(GoalCreator goalRepo);
	
	public void updateGoalRepo(GoalCreator goalRepo);
	
	public List<GoalCreator> getAllGoalCreator();
	
	public GoalCreator getAGoalCreator(String goalCreatorId);
	
	public void deleteAGoalCreator(String goalCreatorId);

}
