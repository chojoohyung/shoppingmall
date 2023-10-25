package com.yuhan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhan.dto.OrderProductDto;
import com.yuhan.entity.OrderProduct;
import com.yuhan.repository.OrderProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderProductService {
	private final OrderProductRepository orderProductRepository;
	
	public List<OrderProductDto> findByName(String username){
		List<OrderProduct> orderProductList = orderProductRepository.findOrderProductByUserName(username);
		
		List<OrderProductDto> orderProductDtoList = new ArrayList<>();
		for (OrderProduct orderProduct : orderProductList) {
			OrderProductDto orderProductDto = OrderProductDto.of(orderProduct);
			orderProductDtoList.add(orderProductDto);
		}
		
		return orderProductDtoList;
	}
	
	public OrderProduct findById(Long id) {
		return orderProductRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
}
