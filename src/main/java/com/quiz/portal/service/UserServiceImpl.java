package com.quiz.portal.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.portal.Entities.Role;
import com.quiz.portal.Entities.User;
import com.quiz.portal.Entities.UserRole;
import com.quiz.portal.constants.commonconstant;
import com.quiz.portal.pojo.UserResponse;
import com.quiz.portal.repository.RoleRepository;
import com.quiz.portal.repository.userRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private userRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserResponse addNewUser(User user,Set<UserRole> roles) {
		System.out.println("In services!!");
		if(userRepository.findByUserName(user.getUserName())!=null) {
			System.out.println("user exist");
			return new UserResponse(false,"user name already exist!",null);
		}
		System.out.println("setting users roles");
		for(UserRole userRole:roles) {
			roleRepository.save(userRole.getRole());
		}
		System.out.println("role also saved");
		user.getUserRoles().addAll(roles);

		userRepository.save(user);
		return new UserResponse(true,"User created successfully!!", user);
	}

}
