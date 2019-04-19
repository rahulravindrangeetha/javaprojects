package com.rahul.journal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.journal.entity.AppData;
import com.rahul.journal.entity.Journal;
import com.rahul.journal.service.GoalService;
import com.rahul.journal.service.JournalService;

@RequestMapping(value="/journal")
@RestController
@CrossOrigin
public class JournalController 
{
	
	 @Autowired
	 private JournalService journalService;
	 
	 @Autowired
	 private GoalService goalService;
	
	 @RequestMapping(value="/new",method=RequestMethod.POST)
	 public ResponseEntity createJournal(@RequestBody AppData data)
	 {
		 journalService.createJournal(data.getJournal());
		 goalService.createUpdateGoals(data.getGoals());
		 return new ResponseEntity(HttpStatus.CREATED); 
	 }
	 
	 @RequestMapping(value="/get/{journalId}",method=RequestMethod.GET)
	 public ResponseEntity getJournal(@PathVariable("journalId") String journalId)
	 {
		 Optional<Journal> journal = journalService.getJournal(journalId);
		 return new ResponseEntity(journal,HttpStatus.OK); 
	 }
	 
	 @RequestMapping(value="/update",method=RequestMethod.PUT)
	 public ResponseEntity updateJournal(@RequestBody Journal journal)
	 {
		 journalService.updateJournal(journal);
		 return new ResponseEntity(HttpStatus.OK); 
	 }
	 
	 

}
