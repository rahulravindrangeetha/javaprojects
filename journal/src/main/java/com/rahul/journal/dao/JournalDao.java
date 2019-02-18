package com.rahul.journal.dao;

import java.util.Optional;

import com.rahul.journal.entity.Journal;

public interface JournalDao 
{
	public void createOrUpdateJournal(Journal journal);
	
	public Optional<Journal> getJournal(int journalId);
	
}
