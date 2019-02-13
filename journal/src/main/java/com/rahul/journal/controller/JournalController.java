package com.rahul.journal.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.journal.entity.Journal;

@RequestMapping("/journal")
@RestController
public class JournalController 
{
	 @RequestMapping(value="/new",method=RequestMethod.POST)
	 public ResponseEntity createJournal(@RequestBody Journal journal)
	 {
		return null; 
	 }
	 
	 @RequestMapping(value="/get/{journalId}",method=RequestMethod.GET)
	 public ResponseEntity getJournal(@PathVariable("journalId") int journalId)
	 {
		return null; 
	 }
	 
	 @RequestMapping(value="/new",method=RequestMethod.PUT)
	 public ResponseEntity updateJournal(@RequestBody Journal journal)
	 {
		return null; 
	 }
	 
	 

}
