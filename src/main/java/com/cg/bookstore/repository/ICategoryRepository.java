package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>{

//	public Category addCategory(String categoryName);
//	public Category editCategory(Category cat);
//	public Category viewAllCategories();
//	public Category removeCategory(Category cat);
}
