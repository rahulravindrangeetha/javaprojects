package com.rahul.journal.service;

import java.util.Optional;

import com.rahul.journal.entity.Journal;

public interface JournalService 
{
	public void createOrUpdateJournal(Journal journal);
	
	public Optional<Journal> getJournal(int journalId);
	
}
