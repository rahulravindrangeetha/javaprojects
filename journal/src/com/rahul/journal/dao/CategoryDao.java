package com.rahul.journal.dao;

import java.util.List;

import com.rahul.journal.entity.Category;

public interface CategoryDao 
{
	public void createCategory(Category category);
	
	public Category getACategory(String categoryId);
	
	public List<Category> getAllCategories();
	
	public void deleteCategory(String categoryId);
	
	public void updateCategory(Category category);

}
