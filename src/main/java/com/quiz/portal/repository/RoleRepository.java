package com.quiz.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.portal.Entities.Role;
import com.quiz.portal.Entities.UserRole;

public interface RoleRepository extends JpaRepository<Role, Long> {

	void save(UserRole userRole);

}
