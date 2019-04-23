package com.rahul.journal.dao;

import java.util.List;
import java.util.Optional;

import com.rahul.journal.entity.Journal;

public interface JournalDao 
{
	public void createJournal(Journal journal);
	
	public void updateJournal(Journal journal);
	
	public Optional<Journal> getJournal(String journalId);

	public List<Journal> getAllJournal();
	
}
