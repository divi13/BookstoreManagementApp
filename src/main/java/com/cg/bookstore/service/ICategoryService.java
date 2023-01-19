package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entity.Category;

public interface ICategoryService {

	public Category addCategory(Category categoryName);
	public Category editCategory(Category cat);
	public List<Category> viewAllCategories();
	public void removeCategory(int cat);
}
