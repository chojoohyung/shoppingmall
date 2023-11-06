package com.yuhan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhan.entity.Used;
import com.yuhan.entity.UsedComment;
import com.yuhan.repository.OrderProductRepository;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.UsedCommentRepository;
import com.yuhan.repository.UsedRepository;
import com.yuhan.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsedCommentService {
	
	private final UsedCommentRepository usedCommentRepository;
	private final UserRepository userRepository;
	private final UsedRepository usedRepository;
	
	public List<UsedComment> findusedId(Long id){
		List<UsedComment> usedCommentList = usedCommentRepository.findByused_id(id);
		
		return usedCommentList;
	}
	
	public UsedComment save(UsedComment usedComment, Long usedId, String username) {
		usedComment.setUsed(usedRepository.findByid(usedId));
		usedComment.setUser(userRepository.findByUsername(username));
		return usedCommentRepository.save(usedComment);
	}

}
