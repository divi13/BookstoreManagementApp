package com.cg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entity.Category;
import com.cg.bookstore.service.ICategoryService;

@CrossOrigin("http://localhost:3000")
@RestController
public class CategoryController {
	@Autowired
	private ICategoryService icategoryService;
	
	@PostMapping("/category/save")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category newCategory = icategoryService.addCategory(category);
		ResponseEntity<Category> responseEntity = new ResponseEntity<>(newCategory, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/category/all")
	public List<Category> fetchAllCategories() {
		List<Category> list = icategoryService.viewAllCategories();
		return list;
	}
	
	@PutMapping("/category/update")
	public ResponseEntity<Object> modifyCategory(@RequestBody Category category){
		ResponseEntity<Object> responseEntity=null;
		Category updatedCategory=icategoryService.editCategory(category);
		responseEntity =new ResponseEntity<>(updatedCategory,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<String> removeCategory(@PathVariable("id")int category){
		ResponseEntity<String> responseEntity=null;
		icategoryService.removeCategory(category);
		responseEntity=new ResponseEntity<>("category deleted",HttpStatus.OK);
		return responseEntity;
	}
}
