package com.rahul.journal.util;

public enum GoalType 
{
	Day("Day"),
	Weekly("Weekly"),
	Monthly("Monthly"),
	Yearly("Yearly");
	
	private String goalType;
	
	private GoalType(String goalType)
	{
		this.goalType=goalType;
	}

}
