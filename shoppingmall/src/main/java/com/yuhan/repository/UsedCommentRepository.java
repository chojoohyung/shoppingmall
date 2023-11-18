package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.UsedComment;

public interface UsedCommentRepository extends JpaRepository<UsedComment,  Long> {
	
	List<UsedComment> findByused_id(Long id);

	
}
