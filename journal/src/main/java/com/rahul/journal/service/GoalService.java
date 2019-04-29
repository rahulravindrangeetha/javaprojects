package com.rahul.journal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.rahul.journal.entity.Goal;

public interface GoalService 
{
	
	public void createUpdateGoals(List<Goal> goals);

	public List<Goal> fetchGoals(LocalDate date);

}
