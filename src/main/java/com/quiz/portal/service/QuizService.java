package com.quiz.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.portal.Entities.Quiz;
import com.quiz.portal.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	
	public Quiz addQuiz(Quiz quiz) {
		System.out.println("Going to save! "+quiz.toString());
		return quizRepository.save(quiz);
	}
	
	public Quiz updateQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}
	
	public List<Quiz> getAllQuizes(){
		return quizRepository.findAll();
	}
	
	public Quiz getQuiz(Long quizId) {
		return quizRepository.findByQuizId(quizId);
	}
	public void delete(Long quizId) {
		Quiz quiz=new Quiz();
		quiz.setQuizId(quizId);
		quizRepository.delete(quiz);
		System.out.println("deleted!");
	}
}
