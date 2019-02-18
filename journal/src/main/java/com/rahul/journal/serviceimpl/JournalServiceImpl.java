package com.rahul.journal.serviceimpl;

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
	public void createOrUpdateJournal(Journal journal) 
	{
		journalDao.createOrUpdateJournal(journal);

	}

	@Override
	public Optional<Journal> getJournal(int journalId) 
	{
		// TODO Auto-generated method stub
		return journalDao.getJournal(journalId);
	}


}
