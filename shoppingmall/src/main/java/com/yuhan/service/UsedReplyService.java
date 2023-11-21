package com.yuhan.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhan.entity.UsedComment;
import com.yuhan.entity.UsedReply;
import com.yuhan.repository.UsedReplyRepository;
import com.yuhan.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsedReplyService {
	
	private final UsedReplyRepository usedReplyRepository;
	private final UsedCommentService usedCommentService;
	private final UserRepository userRepository;
	
	public List<UsedReply> findByUsedComment(UsedComment usedComment) {
		return usedReplyRepository.findByusedComment(usedComment);
	}
	
	public UsedReply save(Long id, String content, Boolean isPrivate, String username, Long replyId) {
		UsedComment usedComment = usedCommentService.findById(replyId);
		
		UsedReply usedReply = new UsedReply();
		usedReply.setUsedComment(usedComment);
		usedReply.setContent(content);
		usedReply.setUser(userRepository.findByUsername(username));
		usedReply.setReplyDate(LocalDateTime.now());
		usedReply.setIsPrivate(isPrivate);
		
		return usedReplyRepository.save(usedReply);
	}
	
}
