package com.yuhan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yuhan.entity.Used;

public interface UsedRepository extends JpaRepository<Used,  Long> {
	
	List<Used> findByOrderByIdDesc();
	
	@Query("SELECT u FROM Used u ORDER BY u.id desc")
	Page<Used> queryAnnotion(Pageable paging);
}
