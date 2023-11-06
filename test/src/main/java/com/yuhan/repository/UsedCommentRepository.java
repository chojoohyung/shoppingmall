package com.yuhan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yuhan.entity.Used;
import com.yuhan.entity.UsedComment;

public interface UsedCommentRepository extends JpaRepository<UsedComment,  Long> {
	
	List<UsedComment> findByused_id(Long id);
	
}
