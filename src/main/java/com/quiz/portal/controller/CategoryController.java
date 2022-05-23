package com.quiz.portal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.portal.Entities.Category;
import com.quiz.portal.service.CategoryService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	Logger logger=LoggerFactory.getLogger(CategoryController.class);
	
	@GetMapping("/")
	public List<Category> getAllCategory(){
		return categoryService.getAllCategory();
	}
	
	@PostMapping("/")
	public String addNewCategory(@RequestBody Category category) {
		categoryService.addNewCategory(category);
		return "category added successfully!";
	}
	
	@PutMapping("/")
	public String updateCategory(@RequestBody Category category) {
		categoryService.updateCategory(category);
		return "category updated successfully!";
	}
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable Long categoryId) {
		Category category=categoryService.getCategoryById(categoryId);
		categoryService.deletCategory(category);
	}
	
	@GetMapping("/{categoryId}")
	public Category getCategoryById(@PathVariable Long categoryId) {
		return categoryService.getCategoryById(categoryId);
	}
}
