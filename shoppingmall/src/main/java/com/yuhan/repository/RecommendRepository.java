package com.yuhan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yuhan.entity.Recommend;
import com.yuhan.entity.Used;
import com.yuhan.entity.UsedComment;
import com.yuhan.entity.User;

public interface RecommendRepository extends JpaRepository<Recommend,  Long> {
	
	Recommend findByUser(User user);
	
}
