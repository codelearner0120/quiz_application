package com.quiz.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.portal.Entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>{
	public Quiz save(Quiz quiz);
	public List<Quiz> findAll();
	public Quiz findByQuizId(Long id);
	public void deleteByQuizId(Long qid);
	public void delete(Quiz quiz);
}
