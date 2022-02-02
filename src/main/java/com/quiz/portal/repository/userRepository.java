package com.quiz.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.portal.Entities.User;

public interface userRepository extends JpaRepository<User, Long>{

}
