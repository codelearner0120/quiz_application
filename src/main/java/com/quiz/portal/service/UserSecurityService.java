package com.quiz.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quiz.portal.Entities.User;
import com.quiz.portal.repository.userRepository;

@Service
public class UserSecurityService implements UserDetailsService{

	@Autowired
	private userRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("userName came here!");
		User user=userRepository.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found!");
		}
		return user;
	}

}
