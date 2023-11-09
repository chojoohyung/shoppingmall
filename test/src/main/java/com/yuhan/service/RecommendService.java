package com.yuhan.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhan.dto.ProductDto;
import com.yuhan.entity.Product;
import com.yuhan.entity.Recommend;
import com.yuhan.entity.User;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.RecommendRepository;
import com.yuhan.test.ACC;
import com.yuhan.test.BOTTOM;
import com.yuhan.test.CategoryMap;
import com.yuhan.test.OUTER;
import com.yuhan.test.RecommendInterface;
import com.yuhan.test.SHIRTS;
import com.yuhan.test.SHOES;
import com.yuhan.test.SizeMap;
import com.yuhan.test.TOP;
import com.yuhan.test.T_SHIRTS;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RecommendService {
	private final RecommendRepository recommendRepository;
	private final ProductRepository productRepository;
	private final UserService userService;
	
	public void updateRecommend(Long id, String username, int RecommendViewOrBuy) {
		Product product = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		User user = userService.findByUsername(username);
		Recommend recommend = recommendRepository.findByUser(user);
		
		String productCategory = product.getCategory();
		String productSize = product.getSize();
		String productColor = product.getColor();
		
		CategoryMap categoryMap = new CategoryMap();
		SizeMap sizeMap = new SizeMap();
		
		
		categoryMap.getCategoryUpdater(productCategory).update(recommend, RecommendViewOrBuy);
		sizeMap.getSizeUpdater(productSize).update(recommend, RecommendViewOrBuy);
		
		
		recommendRepository.save(recommend);
	}
	
	public List<Product> RecommendList(String username){
		
		User user = userService.findByUsername(username);
		Recommend recommend = recommendRepository.findByUser(user);
		
		Map<String, Integer> OrderBycategory = new HashMap<>();
		OrderBycategory.put("TOP", recommend.getCategory_TOP());
		OrderBycategory.put("BOTTOM", recommend.getCategory_BOTTOM());
		OrderBycategory.put("T-SHIRTS", recommend.getCategory_T_SHIRT());
		OrderBycategory.put("SHIRTS", recommend.getCategory_SHIRT());
		OrderBycategory.put("OUTER", recommend.getCategory_OUTER());
		OrderBycategory.put("SHOES", recommend.getCategory_SHOES());
		OrderBycategory.put("ACC", recommend.getCategory_ACC());
		
		List<String> keySet = new ArrayList<>(OrderBycategory.keySet());	
		keySet.sort((o1, o2) -> OrderBycategory.get(o2).compareTo(OrderBycategory.get(o1)));
		
		int keycnt= 0;
		int pageInt = 5;
		List<Product> allProducts = new ArrayList<>();
		
		while(true) {
			if(allProducts.size()==5 || keycnt >= 7)
				break;
			
			Pageable paging = PageRequest.of(0, pageInt);
			Page<Product> productList = productRepository.testcatogoryfind(keySet.get(keycnt), username, paging);
			allProducts.addAll(productList.getContent());
			
			if(allProducts.size()==5) {
				break;
			}else {
				pageInt -= productList.getTotalElements();
				keycnt++;
			}
		}
		
		
		return allProducts;
	}
	
}
