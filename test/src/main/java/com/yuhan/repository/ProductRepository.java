package com.yuhan.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yuhan.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findProductByName(String name);
	
	@Query("SELECT p FROM Product p ORDER BY p.id desc")
	List<Product> queryAnnotion(Pageable paging);
	
	@Query("SELECT p.name FROM Product p WHERE p.id = :id")
	String findIdByName(@Param("id")Long id);
	
	@Query("SELECT p FROM Product p WHERE p.category = :category ORDER BY p.id desc")
	List<Product> catogoryfind(Pageable paging, @Param("category") String category);
	
}
