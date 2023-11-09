package com.yuhan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yuhan.entity.Product;
import com.yuhan.entity.User;


public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findProductByName(String name);
	
	@Query("SELECT p FROM Product p WHERE p.is_delete = false ORDER BY p.id desc")
	List<Product> queryAnnotion(Pageable paging);
	
	@Query("SELECT p FROM Product p WHERE p.is_delete = false ORDER BY p.sales desc")
	List<Product> queryAnnotionsales(Pageable paging);
	
	@Query("SELECT p.name FROM Product p WHERE p.id = :id")
	String findIdByName(@Param("id")Long id);
	
	@Query("SELECT p FROM Product p WHERE p.category = :category AND p.is_delete = false ORDER BY p.id desc")
	List<Product> catogoryfind(Pageable paging, @Param("category") String category);
	
	@Query("SELECT p FROM Product p WHERE p.category = :category AND p.is_delete = false ORDER BY p.sales desc")
	List<Product> catogoryfindsales(Pageable paging, @Param("category") String category);
	
	@Query("SELECT p FROM Product p WHERE p.category = :category AND p.size = :size AND p.color = :color AND p.is_delete = false AND p.id NOT IN (SELECT op.product.id FROM OrderProduct op WHERE op.order.user.username = :username) ORDER BY p.id DESC")
	Page<Product> testcatogoryfind(@Param("category") String category, @Param("size") String size, @Param("color") String color, @Param("username") String username, Pageable paging);
	
	
	
}
