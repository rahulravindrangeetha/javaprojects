package com.rahul.journal.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.journal.dao.GoalDao;
import com.rahul.journal.dao.GoalRepoDao;
import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalHub;
import com.rahul.journal.service.GoalService;

@Service
public class GoalServiceImpl implements GoalService 
{
	@Autowired
	private GoalDao goalDao;
	
	@Autowired
	private GoalRepoDao goalRepoDao;

	@Override
	public void createUpdateGoals(List<Goal> goals) 
	{
		goalDao.createUpdateGoals(goals);

	}

	@Override
	public List<Goal> fetchGoals(LocalDate date) 
	{
		List<Goal> goalsFromDB=goalDao.fetchGoals(date);
		List<String> addedGoalDesc=getListOfGoalsDesc(goalsFromDB);
		List<GoalHub> goalsFromHub=goalRepoDao.getAllGoalCreatorForADate(date,addedGoalDesc);
		return null;
	}

	private List<String> getListOfGoalsDesc(List<Goal> goalsFromDB) 
	{
		List<String> goalDescs= new ArrayList<String> ();
		for(Goal goal:goalsFromDB )
		{
			goalDescs.add(goal.getDesc());
		}
		return goalDescs;
	}

}
