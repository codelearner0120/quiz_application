package com.quiz.portal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.portal.Entities.JwtRequest;
import com.quiz.portal.Entities.JwtResponse;
import com.quiz.portal.Entities.User;
import com.quiz.portal.config.JwtUtils;
import com.quiz.portal.service.UserSecurityService;

@RestController
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private void authenticate(String userName,String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		}
		catch(DisabledException e){
			throw new Exception("user disabled "+e.getMessage());
		}
		catch(BadCredentialsException e) { 
			throw new Exception("Invalid credentials "+e.getMessage());
		}
	}
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getUserName(),jwtRequest.getPassword());
		}catch(UsernameNotFoundException e) {
			throw new Exception("User Not Found!");
		}
		UserDetails user=userSecurityService.loadUserByUsername(jwtRequest.getUserName());
		String token=jwtUtils.generateToken(user);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		UserDetails user=userSecurityService.loadUserByUsername(principal.getName());
		return (User)user;
	}
}
