package com.rahul.journal.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.journal.dao.CategoryDao;
import com.rahul.journal.entity.Category;
import com.rahul.journal.repo.CategoryRepo;

@Repository
public class CategoryDaoImpl implements CategoryDao 
{
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public void createCategory(Category category) {
		categoryRepo.save(category);

	}

	@Override
	public Category getACategory(String categoryId) {
		// TODO Auto-generated method stub
		Optional<Category> category= categoryRepo.findById(categoryId);
		if(category.isPresent())
			return category.get();
		else
			return null;
			
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public void deleteCategory(String categoryId) {
		categoryRepo.deleteById(categoryId);

	}

	@Override
	public void updateCategory(Category category) 
	{
		categoryRepo.save(category);

	}

}
