package com.rahul.journal.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.journal.dao.JournalDao;
import com.rahul.journal.entity.Journal;
import com.rahul.journal.repo.JournalRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class JournalDaoImpl implements JournalDao 
{
	@Autowired
	JournalRepo journalRepo;

	@Override
	public void createJournal(Journal journal) 
	{
		journalRepo.save(journal);

	}
	
	@Override
	public void updateJournal(Journal journal) 
	{
		Journal existingJournal=journalRepo.findById(journal.getId()).get();
		System.out.println("existingJournal->"+existingJournal);
		modifyData(existingJournal,journal);
		journalRepo.save(existingJournal);
		

	}

	private void modifyData(Journal existingJournal, Journal journal) 
	{
		existingJournal.setAttachments(journal.getAttachments());
		existingJournal.setDate(journal.getDate());
		existingJournal.setJournal(journal.getJournal());
		existingJournal.setTagValue(journal.getTagValue());
		existingJournal.setTime(journal.getTime());
		existingJournal.setTitle(journal.getTitle());
		
	}

	@Override
	public Optional<Journal> getJournal(LocalDate date) 
	{
		// TODO Auto-generated method stub
		return Optional.of(journalRepo.findByDate(date));
	}

	@Override
	public List<Journal> getAllJournal() 
	{
		// TODO Auto-generated method stub
		return journalRepo.findAll();
	}

}
