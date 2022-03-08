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
	public void delete(long quizId) {
		System.out.println("We are deleting quizId "+quizId);
		quizRepository.deleteById(quizId);
	}
}
