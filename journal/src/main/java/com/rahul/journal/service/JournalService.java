package com.rahul.journal.service;

import com.rahul.journal.entity.Journal;

public interface JournalService 
{
	public void createJournal(Journal journal);
	
	public Journal getJournal(int journalId);
	
	public void updateJournal(Journal journal);

}
