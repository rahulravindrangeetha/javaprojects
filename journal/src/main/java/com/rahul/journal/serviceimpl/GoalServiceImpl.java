package com.rahul.journal.serviceimpl;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.journal.dao.GoalDao;
import com.rahul.journal.dao.GoalRepoDao;
import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalHub;
import com.rahul.journal.service.GoalService;
import com.rahul.journal.util.GoalType;

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
		goalsFromDB.addAll(convertGoalsFromHub(goalsFromHub));
		return null;
	}

	private List<Goal> convertGoalsFromHub(List<GoalHub> goalsFromHub)
	{
		List<Goal> convertedGoals = new ArrayList<Goal>();
		
		for(GoalHub goalFromHub : goalsFromHub)
		{
			Goal goal = new Goal();
			goal.setCategory(goalFromHub.getCategory());
			goal.setType(goalFromHub.getType());
			setDates(goal,goalFromHub);
		}
		return convertedGoals;
	}

	private void setDates(Goal goal, GoalHub goalFromHub) 
	{
		LocalDate currentDate = LocalDate.now();
		if(goalFromHub.getType().equals(GoalType.Day))
		{
			goal.setStartDate(currentDate);
			goal.setExpectedEndDate(currentDate);
		}
		else if(goalFromHub.getType().equals(GoalType.Weekly))
		{
			goal.setStartDate(currentDate.with(DayOfWeek.MONDAY));
			goal.setExpectedEndDate(currentDate.with(DayOfWeek.SUNDAY));
		}
		else if(goalFromHub.getType().equals(GoalType.Monthly))
		{
			goal.setStartDate(currentDate.withDayOfMonth(1));
			goal.setExpectedEndDate(currentDate.with(TemporalAdjusters.lastDayOfMonth()));
		}
		else
		{
			goal.setStartDate(currentDate.withDayOfYear(1));
			goal.setExpectedEndDate(currentDate.with(TemporalAdjusters.lastDayOfYear()));
			
		}
		SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyyy");
		goal.setEndDate(LocalDate.of(9999,Month.DECEMBER,1));
		
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
