package com.yuhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.Order;
import com.yuhan.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	
	
}
