package com.rahul.journal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.journal.dao.CategoryDao;
import com.rahul.journal.entity.Category;
import com.rahul.journal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService 
{
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void createCategory(Category category) 
	{
		categoryDao.createCategory(category);

	}

	@Override
	public Category getACategory(String categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.getACategory(categoryId);
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategories();
	}

	@Override
	public void deleteCategory(String categoryId) 
	{
		categoryDao.deleteCategory(categoryId);

	}

	@Override
	public void updateCategory(Category category) 
	{
		categoryDao.updateCategory(category);

	}

}
