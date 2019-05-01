package com.rahul.journal.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
	
	 @RequestMapping(value="/save",method=RequestMethod.POST)
	 @Transactional
	 public ResponseEntity saveJournal(@RequestBody AppData data)
	 {
		 journalService.createJournal(data.getJournal());
		 goalService.createUpdateGoals(data.getGoals());
		 return new ResponseEntity(HttpStatus.CREATED); 
	 }
	 
	 @RequestMapping(value="/create/{date}",method=RequestMethod.GET)
	 @Transactional
	 public ResponseEntity createJournal(@PathVariable("date") String date)
	 {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 return new ResponseEntity(goalService.fetchGoals(LocalDate.parse(date,formatter)),HttpStatus.OK); 
	 }
	 
	 @RequestMapping(value="/get/{date}",method=RequestMethod.GET)
	 public ResponseEntity getJournal(@PathVariable("date") String date)
	 {
		 AppData data = new AppData();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 Optional<Journal> journal = journalService.getJournal(LocalDate.parse(date,formatter));
		 if(journal.isPresent())
		 {
			 data.setJournal(journal.get());
			 data.setGoals(goalService.getGoalsForJournal(LocalDate.parse(date,formatter)));
		 }
		 else
			 data.setJournal(null);
		 
		 return new ResponseEntity(data,HttpStatus.OK); 
	 }
	 
	 @RequestMapping(value="/getAll",method=RequestMethod.GET)
	 public ResponseEntity getAllJournal()
	 {
		 List<Journal> journal = journalService.getAllJournal();
		 return new ResponseEntity(journal,HttpStatus.OK); 
	 }
	 
	 @RequestMapping(value="/update",method=RequestMethod.PUT)
	 public ResponseEntity updateJournal(@RequestBody Journal journal)
	 {
		 journalService.updateJournal(journal);
		 return new ResponseEntity(HttpStatus.OK); 
	 }
	 
	 

}
