package com.quiz.portal.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quizId;
	private String title;
	private String description;
	private Long noOfQuestion;
	private Long maxMarks;
	private Boolean active=false;
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> question=new HashSet<>();
	public Quiz() {
		super();
	}
	public Long getQuizId() {
		return quizId;
	}
	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getNoOfQuestion() {
		return noOfQuestion;
	}
	public void setNoOfQuestion(Long noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}
	public Long getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(Long maxMarks) {
		this.maxMarks = maxMarks;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Question> getQuestion() {
		return question;
	}
	public void setQuestion(Set<Question> question) {
		this.question = question;
	}	
	@Override
	public String toString() {
		return "Quiz [title=" + title + ", description=" + description + ", noOfQuestion=" + noOfQuestion
				+ ", maxMarks=" + maxMarks + ", active=" + active + "]";
	}
}
