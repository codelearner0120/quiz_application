package com.quiz.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.portal.Entities.Question;
import com.quiz.portal.Entities.Quiz;
import com.quiz.portal.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}

	public List<Question> getQuestions(Question question) {
		return questionRepository.findAll();
	}
	
	public Question getQuestion(Long questionId) {
		return questionRepository.findByQuesId(questionId);
	}

	public void deleteQuestion(Long questionId) {
		Question question=questionRepository.getById(questionId);
		questionRepository.delete(question);
	}

	public List<Question> getQuestionOfQuiz(Quiz quiz) {
		return questionRepository.findByQuiz(quiz);
	}
}
