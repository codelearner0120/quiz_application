package com.quiz.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.portal.Entities.User;

public interface userRepository extends JpaRepository<User, Long>{
	public User findByUserName(String userName);
	public User save(User users);
}
