package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.Product;
import com.yuhan.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findUserByUsername(String username);
	
}
