package com.quiz.portal.controller;

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

import com.quiz.portal.Entities.Quiz;
import com.quiz.portal.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(quizService.addQuiz(quiz));
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
	return ResponseEntity.ok(quizService.updateQuiz(quiz));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllQuizes(){
		return ResponseEntity.ok(quizService.getAllQuizes());
	}
	
	@GetMapping("/{qid}")
	public ResponseEntity<?> getQuiz(@PathVariable("qid") long qid){
		return ResponseEntity.ok(quizService.getQuiz(qid));
	}
	
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable("qid") long qid){
		quizService.delete(qid);
	}
}
