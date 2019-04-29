package com.rahul.journal.dao;

import java.time.LocalDate;
import java.util.List;

import com.rahul.journal.entity.Goal;

public interface GoalDao 
{
	public void createUpdateGoals(List<Goal> goals);

	public List<Goal> fetchGoals(LocalDate date);

}
