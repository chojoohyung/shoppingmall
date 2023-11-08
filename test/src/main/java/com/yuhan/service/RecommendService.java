package com.yuhan.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhan.dto.ProductDto;
import com.yuhan.entity.Product;
import com.yuhan.entity.Recommend;
import com.yuhan.entity.User;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.RecommendRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RecommendService {
	private final RecommendRepository recommendRepository;
	private final ProductRepository productRepository;
	private final UserService userService;
	
	public void updateRecommend(Long id, String username) {
		Product product = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		User user = userService.findByUsername(username);
		Recommend recommend = recommendRepository.findByUser(user);
		
		System.out.println(product.getCategory());
		if(product.getCategory().equals("TOP")) {
			System.out.println("asdada");
			recommend.setCategory_TOP(recommend.getCategory_TOP()+1);
			recommendRepository.save(recommend);
		}
	}
	
	public List<ProductDto> RecommendList(String username){
		User user = userService.findByUsername(username);
		Recommend recommend = recommendRepository.findByUser(user);
		
		List<Integer> maxList = new ArrayList<>();
		maxList.add(recommend.getCategory_TOP());
		maxList.add(recommend.getCategory_BOTTOM());
		maxList.add(recommend.getCategory_ACC());
		
		System.out.println(Collections.max(maxList));
		
		
		
		return null;
	}
	
}
