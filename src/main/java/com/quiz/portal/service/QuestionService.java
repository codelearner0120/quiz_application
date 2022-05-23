package com.quiz.portal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.portal.Entities.Question;
import com.quiz.portal.Entities.Quiz;
import com.quiz.portal.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	Logger logger=LoggerFactory.getLogger(QuestionService.class);

	public Question addQuestion(Question question) {
		logger.info("adding a question with id :"+question.getQuesId());
		return questionRepository.save(question);
	}

	public Question updateQuestion(Question question) {
		logger.info("updating a question with id :"+question.getQuesId());
		return questionRepository.save(question);
	}

	public List<Question> getQuestions(Question question) {
		return questionRepository.findAll();
	}
	
	public Question getQuestion(Long questionId) {
		logger.info("getting a question with id :"+questionId);
		return questionRepository.findByQuesId(questionId);
	}

	public void deleteQuestion(Long questionId) {
		Question question=questionRepository.getById(questionId);
		logger.info("deleting a question with id :"+questionId);
		questionRepository.delete(question);
	}

	public List<Question> getQuestionOfQuiz(Quiz quiz) {
		return questionRepository.findByQuiz(quiz);
	}
}
