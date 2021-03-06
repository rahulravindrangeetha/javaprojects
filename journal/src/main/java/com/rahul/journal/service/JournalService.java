package com.rahul.journal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.rahul.journal.entity.Journal;

public interface JournalService 
{
	public void createJournal(Journal journal);
	
	public Optional<Journal> getJournal(LocalDate date);
	
	public void updateJournal(Journal journal);

	public List<Journal> getAllJournal();
	
}
