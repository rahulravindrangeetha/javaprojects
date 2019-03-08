package com.rahul.journal.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.journal.dao.GoalDao;
import com.rahul.journal.repo.GoalRepo;
import com.rahul.journal.entity.Goal;

@Repository
public class GoalDaoImpl implements GoalDao 
{

	@Autowired
	private GoalRepo goalRepo;

	
	public void createUpdateGoals(List<Goal> goals) 
	{
		goalRepo.saveAll(goals);
		
	} 
	
	

}
