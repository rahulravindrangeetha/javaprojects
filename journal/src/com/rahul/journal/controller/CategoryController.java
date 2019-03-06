package com.rahul.journal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.journal.entity.Category;

@RequestMapping("/category")
@RestController
@CrossOrigin
public class CategoryController 
{
	@RequestMapping(value="/new")
	public ResponseEntity createCategory(@RequestBody Category category)
	{
		return null;
	}
	

}
