package com.yuhan.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhan.entity.UsedReplyComment;
import com.yuhan.repository.UsedCommentRepository;
import com.yuhan.repository.UsedReplyCommentRepository;
import com.yuhan.repository.UsedRepository;
import com.yuhan.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsedReplyCommentService {
	
	public UsedReplyComment save(Long usedId, String content, String username, Long replyid) {
		return null;
	}
	
	
}
