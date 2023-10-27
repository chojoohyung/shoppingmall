package com.yuhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	Cart findByUserId(Long id);
	
	
}
