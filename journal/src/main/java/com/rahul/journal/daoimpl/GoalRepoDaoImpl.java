package com.rahul.journal.daoimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.journal.dao.GoalDao;
import com.rahul.journal.dao.GoalRepoDao;
import com.rahul.journal.repo.GoalRepo;
import com.rahul.journal.repo.GoalRepoRepo;
import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalHub;

@Repository
public class GoalRepoDaoImpl implements GoalRepoDao 
{

	@Autowired
	private GoalRepoRepo goalRepoRepo;

	@Override
	public void createGoalRepo(GoalHub goalRepo) 
	{
		goalRepoRepo.save(goalRepo);
		
	}

	@Override
	public void updateGoalRepo(GoalHub goalRepo) 
	{
		goalRepoRepo.save(goalRepo);
		
	}

	@Override
	public List<GoalHub> getAllGoalCreator() 
	{
		
		return goalRepoRepo.findAll();
	}

	@Override
	public GoalHub getAGoalCreator(String goalCreatorId) 
	{
		
		return goalRepoRepo.findById(goalCreatorId).get();
	}

	@Override
	public void deleteAGoalCreator(String goalCreatorId) 
	{
		goalRepoRepo.deleteById(goalCreatorId);
		
	}

	@Override
	public List<GoalHub> getAllGoalCreatorForADate(LocalDate date, List<String> addedGoalDesc)
	{
		// TODO Auto-generated method stub
		return goalRepoRepo.getAllGoalCreatorForADate(date,addedGoalDesc);
	}
	
	

		

}
