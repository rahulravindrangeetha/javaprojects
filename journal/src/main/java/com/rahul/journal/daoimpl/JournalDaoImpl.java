package com.rahul.journal.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.journal.dao.JournalDao;
import com.rahul.journal.entity.Journal;
import com.rahul.journal.repo.JournalRepo;
import java.util.Optional;

@Repository
public class JournalDaoImpl implements JournalDao 
{
	@Autowired
	JournalRepo journalRepo;

	@Override
	public void createOrUpdateJournal(Journal journal) 
	{
		journalRepo.save(journal);

	}

	@Override
	public Optional<Journal> getJournal(int journalId) {
		// TODO Auto-generated method stub
		return journalRepo.findById(journalId);
	}

}
