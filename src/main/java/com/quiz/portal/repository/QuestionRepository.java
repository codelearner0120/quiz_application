package com.quiz.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.portal.Entities.Question;
import com.quiz.portal.Entities.Quiz;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	public Question save(Question Question);
	public List<Question> findAll();
	public List<Question> findByQuiz(Quiz quiz);
	public Question findByQuesId(Long id);
	public void delete(Question Question);
}
