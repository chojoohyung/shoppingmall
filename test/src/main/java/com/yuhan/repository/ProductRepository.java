package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findProductByName(String name);
	
	
}
