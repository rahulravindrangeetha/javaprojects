package com.rahul.journal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.journal.dao.JournalDao;
import com.rahul.journal.entity.Journal;
import com.rahul.journal.service.JournalService;

@Service
public class JournalServiceImpl implements JournalService 
{	
	@Autowired
	JournalDao journalDao;

	@Override
	public void createJournal(Journal journal) 
	{
		journalDao.createJournal(journal);

	}
	
	@Override
	public void updateJournal(Journal journal) 
	{
		journalDao.updateJournal(journal);

	}

	@Override
	public Optional<Journal> getJournal(String journalId) 
	{
		// TODO Auto-generated method stub
		return journalDao.getJournal(journalId);
	}

	@Override
	public List<Journal> getAllJournal() 
	{
		// TODO Auto-generated method stub
		return journalDao.getAllJournal();
	}


}
