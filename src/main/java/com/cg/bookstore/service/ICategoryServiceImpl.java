package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.BookNotFoundException;
import com.cg.bookstore.exception.CategoryNotFoundException;
import com.cg.bookstore.repository.ICategoryRepository;

@Service
public class ICategoryServiceImpl implements ICategoryService{

	@Autowired
	private ICategoryRepository icategoryRepository;
	
	@Override
	public Category addCategory(Category categoryName) {
		Category newCategory=icategoryRepository.save(categoryName);
		return newCategory;
	}

	@Override
	public Category editCategory(Category category) {
		Optional<Category> optionalCategory= icategoryRepository.findById(category.getCategoryId());
		if(optionalCategory.isEmpty()) {
			throw new CategoryNotFoundException("category not found with id :"+category.getCategoryId());
		}
		Category updateCategory=icategoryRepository.save(category);
		return updateCategory;
	}

	@Override
	public List<Category> viewAllCategories() {
		return icategoryRepository.findAll();
	}

	@Override
	public void removeCategory(int category) {
		Optional<Category> optionalCategory= icategoryRepository.findById(category);
		if(optionalCategory.isEmpty()) {
			throw new BookNotFoundException("category not found with id :"+category);
		}
		icategoryRepository.deleteById(category);
	}
}
