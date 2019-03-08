package com.rahul.journal.dao;

import java.util.List;

import com.rahul.journal.entity.Goal;

public interface GoalDao 
{
	public void createUpdateGoals(List<Goal> goals);

}
