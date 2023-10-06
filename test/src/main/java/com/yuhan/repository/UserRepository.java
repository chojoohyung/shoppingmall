package com.yuhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
}
