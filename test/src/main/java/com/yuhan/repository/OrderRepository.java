package com.yuhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

	
	
}
