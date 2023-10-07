package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yuhan.entity.Order;
import com.yuhan.entity.OrderProduct;


public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

	@Query("SELECT o FROM OrderProduct o WHERE o.product.name = :name")
	List<OrderProduct> findByProductName(@Param("name") String name);
	
	@Query("SELECT o FROM OrderProduct o WHERE o.order.user.username = :username")
	List<OrderProduct> findByUserName(@Param("username") String username);
}
