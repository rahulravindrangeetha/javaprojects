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
		System.out.println("goalsFromDB 1 -->"+goalsFromDB);
		List<String> addedGoalDesc=getListOfGoalsDesc(goalsFromDB);
		System.out.println("addedGoalDesc-->"+addedGoalDesc);
		List<GoalHub> goalsFromHub=goalRepoDao.getAllGoalCreatorForADate(date,addedGoalDesc);
		System.out.println("goalsFromHub-->"+goalsFromHub);
		goalsFromDB.addAll(convertGoalsFromHub(goalsFromHub,date));
		System.out.println("final-->"+goalsFromDB);
		return goalsFromDB;
	}

	private List<Goal> convertGoalsFromHub(List<GoalHub> goalsFromHub, LocalDate date)
	{
		List<Goal> convertedGoals = new ArrayList<Goal>();
		
		for(GoalHub goalFromHub : goalsFromHub)
		{
			Goal goal = new Goal();
			goal.setCategory(goalFromHub.getCategory());
			goal.setType(goalFromHub.getType());
			goal.setDesc(goalFromHub.getDesc());
			setDates(goal,goalFromHub,date);
			convertedGoals.add(goal);
		}
		return convertedGoals;
	}

	private void setDates(Goal goal, GoalHub goalFromHub, LocalDate date) 
	{
		
		if(goalFromHub.getType().equals(GoalType.Day))
		{
			goal.setStartDate(date);
			goal.setExpectedEndDate(date);
		}
		else if(goalFromHub.getType().equals(GoalType.Weekly))
		{
			goal.setStartDate(date.with(DayOfWeek.MONDAY));
			goal.setExpectedEndDate(date.with(DayOfWeek.SUNDAY));
		}
		else if(goalFromHub.getType().equals(GoalType.Monthly))
		{
			goal.setStartDate(date.withDayOfMonth(1));
			goal.setExpectedEndDate(date.with(TemporalAdjusters.lastDayOfMonth()));
		}
		else
		{
			goal.setStartDate(date.withDayOfYear(1));
			goal.setExpectedEndDate(date.with(TemporalAdjusters.lastDayOfYear()));
			
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
