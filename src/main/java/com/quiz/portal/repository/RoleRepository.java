package com.quiz.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.portal.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
