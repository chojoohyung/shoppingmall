package com.yuhan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yuhan.entity.ProductImg;


public interface ProductImgRepository extends JpaRepository<ProductImg, Long> {

	List<ProductImg> findByProductIdOrderByIdAsc(Long id);
	/*
	@Query("SELECT p FROM ProductImg p WHERE p.product = :product_id GROUP BY p.product")
	List<ProductImg> findByCustomId(@Param("product_id")Long id);
	 */
	@Query("SELECT p FROM ProductImg p GROUP BY p.product")
	List<ProductImg> findByCustomView();

	
}
