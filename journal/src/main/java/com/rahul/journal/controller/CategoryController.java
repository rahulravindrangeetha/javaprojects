package com.rahul.journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.journal.entity.Category;
import com.rahul.journal.service.CategoryService;

@RequestMapping("/category")
@RestController
@CrossOrigin
public class CategoryController 
{
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method=RequestMethod.POST, value="/new")
	public ResponseEntity createCategory(@RequestBody Category category)
	{
		categoryService.createCategory(category);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update")
	public ResponseEntity updateCategory(@RequestBody Category category)
	{
		categoryService.updateCategory(category);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/get/{categoryId}")
	public ResponseEntity getACategory(@PathVariable("categoryId") String categoryId)
	{
		return new ResponseEntity(categoryService.getACategory(categoryId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAll")
	public ResponseEntity getAllCategories()
	{
		return new ResponseEntity(categoryService.getAllCategories(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{categoryId}")
	public ResponseEntity deleteACategory(@PathVariable("categoryId") String categoryId)
	{
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	

}
