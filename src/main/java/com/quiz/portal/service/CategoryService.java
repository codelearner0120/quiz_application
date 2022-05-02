package com.quiz.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.portal.Entities.Category;
import com.quiz.portal.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public Category addNewCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void deletCategory(Category category) {
		categoryRepository.delete(category);
	}
	
	public Category getCategoryById(Long id) {
		return categoryRepository.findByCid(id);
	}

}