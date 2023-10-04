package com.yuhan.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yuhan.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findProductByName(String name);
	
	@Query("SELECT p FROM Product p ORDER BY p.id desc")
	List<Product> queryAnnotion(Pageable paging);
	
	
	
}
