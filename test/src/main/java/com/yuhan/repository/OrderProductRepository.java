package com.yuhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.OrderProduct;


public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

	
	
}
