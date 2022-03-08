package com.quiz.portal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.portal.Entities.Role;
import com.quiz.portal.Entities.User;
import com.quiz.portal.Entities.UserRole;
import com.quiz.portal.constants.commonconstant;
import com.quiz.portal.pojo.UserResponse;
import com.quiz.portal.repository.userRepository;
import com.quiz.portal.service.UserService;
import com.quiz.portal.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/adduser")
	public UserResponse addNewUser(@RequestBody User user) {
		Set<UserRole> roles=new HashSet<>();
		
		Role role=new Role();
		Long id=102L;
		role.setRoleId(id);
		role.setRoleName(commonconstant.NORMAL_USER);
		
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		roles.add(userRole);
		return userService.addNewUser(user,roles);
		
	}
	@GetMapping("/test")
	public String getDataFromServer() {
		System.out.println("reached!!");
		return "successfull msg gg";
	}
}
