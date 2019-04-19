package com.rahul.journal.entity;

import java.util.List;

public class AppData 
{
	private Journal journal;
	
	private List<Goal> goals;

	public Journal getJournal()
	{
		return journal;
	}

	public void setJournal(Journal journal) 
	{
		this.journal = journal;
	}

	public List<Goal> getGoals() 
	{
		return goals;
	}

	public void setGoals(List<Goal> goals) 
	{
		this.goals = goals;
	}
	
	
	
	

}
