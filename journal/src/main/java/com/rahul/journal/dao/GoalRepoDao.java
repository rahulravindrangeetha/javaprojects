package com.rahul.journal.dao;

import java.time.LocalDate;
import java.util.List;

import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalHub;

public interface GoalRepoDao 
{
	public void createGoalRepo(GoalHub goalRepo);
	
	public void updateGoalRepo(GoalHub goalRepo);
	
	public List<GoalHub> getAllGoalCreator();
	
	public GoalHub getAGoalCreator(String goalCreatorId);
	
	public void deleteAGoalCreator(String goalCreatorId);
	
	public List<GoalHub> getAllGoalCreatorForADate(LocalDate date, List<String> addedGoalDesc);

}
