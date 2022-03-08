package com.quiz.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.portal.Entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	public List<Category> findAll();
	public Category save(Category category);
	public Category findByCid(Long id);
}
