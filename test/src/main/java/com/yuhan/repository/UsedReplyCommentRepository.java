package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.UsedComment;
import com.yuhan.entity.UsedReplyComment;

public interface UsedReplyCommentRepository extends JpaRepository<UsedReplyComment,  Long> {
	
	List<UsedReplyComment> findByusedComment(UsedComment usedComment);
	
}
