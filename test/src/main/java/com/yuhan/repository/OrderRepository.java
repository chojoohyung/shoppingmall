package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yuhan.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.user.username = :username")
	List<Order> findByUserUsername(@Param("username") String username);
	
	
	
}
