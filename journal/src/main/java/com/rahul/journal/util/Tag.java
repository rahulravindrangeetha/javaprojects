package com.rahul.journal.util;

public enum Tag 
{
	Happy("Happy"),
	Sad("Sad"),
	Achivement("Achivement"),
	Aha("Aha");
	
	private String tagValue;
	
	private Tag(String tagValue)
	{
		this.tagValue=tagValue;
	}
}
