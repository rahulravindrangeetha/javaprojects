package com.rahul.journal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.journal.dao.GoalDao;
import com.rahul.journal.dao.GoalRepoDao;
import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalCreator;
import com.rahul.journal.service.GoalRepoService;
import com.rahul.journal.service.GoalService;

@Service
public class GoalRepoServiceImpl implements GoalRepoService 
{
	@Autowired
	private GoalRepoDao goalDao;

	@Override
	public void createGoalRepo(GoalCreator goalRepo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGoalRepo(GoalCreator goalRepo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GoalCreator> getAllGoalCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoalCreator getAGoalCreator(String goalCreatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAGoalCreator(String goalCreatorId) {
		// TODO Auto-generated method stub
		
	}

	

}
