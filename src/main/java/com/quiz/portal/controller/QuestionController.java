package com.quiz.portal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.portal.Entities.Question;
import com.quiz.portal.Entities.Quiz;
import com.quiz.portal.repository.QuizRepository;
import com.quiz.portal.service.QuestionService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/question")
@CrossOrigin("*")
@Slf4j
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizRepository quizRepository;
	
	
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
	return ResponseEntity.ok(questionService.updateQuestion(question));
	}
	
	// to get all question of any quiz	
	@GetMapping("quiz/{quizId}")
	public ResponseEntity<?> getAllQuestionOfQuiz(@PathVariable("quizId") Long quizId ){
		
		Quiz quiz=quizRepository.findByQuizId(quizId);
		Set<Question> questions=quiz.getQuestion();
		List<Question> result=new ArrayList(questions);
		if(result.size()>quiz.getNoOfQuestion().intValue()) {
			result.subList(0, quiz.getNoOfQuestion().intValue()-1);
		}
		Collections.shuffle(result);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{qid}")
	public ResponseEntity<?> getQuestion(@PathVariable("qid") Long qid){
		return ResponseEntity.ok(questionService.getQuestion(qid));
	}
	
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable("qid") long qid){
		questionService.deleteQuestion(qid);
	}
}
