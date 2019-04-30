package com.rahul.journal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.journal.dao.GoalDao;
import com.rahul.journal.dao.GoalRepoDao;
import com.rahul.journal.entity.Goal;
import com.rahul.journal.entity.GoalHub;
import com.rahul.journal.service.GoalRepoService;
import com.rahul.journal.service.GoalService;

@Service
public class GoalRepoServiceImpl implements GoalRepoService 
{
	@Autowired
	private GoalRepoDao goaRepolDao;

	@Override
	public void createGoalRepo(GoalHub goalRepo) 
	{
		goaRepolDao.createGoalRepo(goalRepo);
		
	}

	@Override
	public void updateGoalRepo(GoalHub goalRepo) 
	{
		goaRepolDao.updateGoalRepo(goalRepo);
		
	}

	@Override
	public List<GoalHub> getAllGoalCreator() {
		// TODO Auto-generated method stub
		return goaRepolDao.getAllGoalCreator();
	}

	@Override
	public GoalHub getAGoalCreator(String goalCreatorId) {
		// TODO Auto-generated method stub
		return goaRepolDao.getAGoalCreator(goalCreatorId);
	}

	@Override
	public void deleteAGoalCreator(String goalCreatorId) {
		// TODO Auto-generated method stub
		goaRepolDao.deleteAGoalCreator(goalCreatorId);
		
	}

	

}
