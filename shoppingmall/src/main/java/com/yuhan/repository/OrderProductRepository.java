package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yuhan.entity.Order;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;


public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

	@Query("SELECT o FROM OrderProduct o WHERE o.product.name = :name")
	OrderProduct findOrderProductByProductName(@Param("name") String name);
	
	@Query("SELECT o FROM OrderProduct o WHERE o.order.user.username = :username")
	List<OrderProduct> findOrderProductByUserName(@Param("username") String username);
	
	@Query("SELECT o FROM OrderProduct o WHERE o.product.id = :id")
	OrderProduct CustomfindById(@Param("id") Long id);
	
	
	List<OrderProduct> findByProduct(Product product);
}
