package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	List<User> findByemail(String email);
	
}
