package com.rahul.journal.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.rahul.journal.entity.Journal;

public interface JournalDao 
{
	public void createJournal(Journal journal);
	
	public void updateJournal(Journal journal);
	
	public Optional<Journal> getJournal(LocalDate date);

	public List<Journal> getAllJournal();
	
}
