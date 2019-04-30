package com.rahul.journal.controller;

import java.util.List;
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
import com.rahul.journal.entity.GoalHub;
import com.rahul.journal.entity.Journal;
import com.rahul.journal.service.GoalRepoService;
import com.rahul.journal.service.GoalService;
import com.rahul.journal.service.JournalService;

import ch.qos.logback.core.net.SyslogOutputStream;

@RequestMapping(value="/goalrepo")
@RestController
@CrossOrigin
public class GoalRepoController 
{
		 
	 @Autowired
	 private GoalRepoService goalRepoService;
	
	 @RequestMapping(value="/new",method=RequestMethod.POST)
	 public ResponseEntity createGoalRepo(@RequestBody GoalHub goalCreator)
	 {
		 System.out.println("newwwww");
		 goalRepoService.createGoalRepo(goalCreator);
		 return new ResponseEntity(HttpStatus.CREATED); 
	 }
	 
	 @RequestMapping(value="/get/{goalRepoId}",method=RequestMethod.GET)
	 public ResponseEntity getGoalRepo(@PathVariable("goalRepoId") String goalRepoId)
	 {
		 GoalHub goalCreator = goalRepoService.getAGoalCreator(goalRepoId);
		 return new ResponseEntity(goalCreator,HttpStatus.OK); 
	 }
	 
	 @RequestMapping(value="/getAll",method=RequestMethod.GET)
	 public ResponseEntity getAllGoalRepo()
	 {
		 return new ResponseEntity(goalRepoService.getAllGoalCreator(),HttpStatus.OK); 
	 }
	 
	 @RequestMapping(value="/update",method=RequestMethod.PUT)
	 public ResponseEntity updateGoalRepo(@RequestBody GoalHub goalCreator)
	 {
		 goalRepoService.updateGoalRepo(goalCreator);
		 return new ResponseEntity(HttpStatus.OK); 
	 }
	 
	 @RequestMapping(value="/delete/{goalRepoId}",method=RequestMethod.DELETE)
	 public ResponseEntity deleteGoalRepo(@PathVariable("goalRepoId") String  goalRepoId)
	 {
		 goalRepoService.deleteAGoalCreator(goalRepoId);
		 return new ResponseEntity(HttpStatus.OK); 
	 }
	 
	 

}
