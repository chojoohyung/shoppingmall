package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.UsedComment;
import com.yuhan.entity.UsedReply;

public interface UsedReplyRepository extends JpaRepository<UsedReply,  Long> {
	
	List<UsedReply> findByusedComment(UsedComment usedComment);
	
}
