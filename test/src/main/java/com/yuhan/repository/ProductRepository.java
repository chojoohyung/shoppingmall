package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByName(String name);
	
	
}
