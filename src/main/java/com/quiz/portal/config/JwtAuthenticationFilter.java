package com.quiz.portal.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.quiz.portal.service.UserSecurityService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader=request.getHeader("Authorization");
		String userName=null;
		String jwtToken=null;
		// Token found
		if(requestTokenHeader!=null&&requestTokenHeader.startsWith("Bearer ")) {
			jwtToken=requestTokenHeader.substring(7);
			try {			
			userName=jwtUtils.extractUsername(jwtToken);
			
			}
			catch(ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("jwt token expired! ");
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception found!!");
			}
		}
		// validate Token
		
		if(userName!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
			final UserDetails userDetails=userSecurityService.loadUserByUsername(userName);
			System.out.println("username is "+userDetails.getUsername()+" "+userDetails.getPassword());
			if(jwtUtils.validateToken(jwtToken, userDetails)) { //token is valid
				UsernamePasswordAuthenticationToken usernamePasswordToken=new UsernamePasswordAuthenticationToken( userDetails, null,userDetails.getAuthorities());
				usernamePasswordToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordToken);
			}
		}
		else {
			System.out.println("Token is not valid!");
		}
		filterChain.doFilter(request, response);
	}

}
