package com.quiz.portal.pojo;

import com.quiz.portal.Entities.User;


public class UserResponse {
	private Boolean status;
	private String msg;
	private User user;
	
	public UserResponse(Boolean status, String msg, User user) {
		super();
		this.status = status;
		this.msg = msg;
		this.user = user;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
