package com.rahul.journal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.journal.dao.GoalDao;
import com.rahul.journal.entity.Goal;
import com.rahul.journal.service.GoalService;

@Service
public class GoalServiceImpl implements GoalService 
{
	@Autowired
	private GoalDao goalDao;

	@Override
	public void createUpdateGoals(List<Goal> goals) 
	{
		goalDao.createUpdateGoals(goals);

	}

}
