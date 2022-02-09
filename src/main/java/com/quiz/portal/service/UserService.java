package com.quiz.portal.service;

import java.util.Set;

import com.quiz.portal.Entities.User;
import com.quiz.portal.Entities.UserRole;
import com.quiz.portal.pojo.UserResponse;

public interface UserService {
	public UserResponse addNewUser(User user,Set<UserRole> roles);
}
