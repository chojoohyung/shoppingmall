package com.yuhan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yuhan.dto.OrderProductDto;
import com.yuhan.dto.ProductImgDto;
import com.yuhan.entity.Order;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.ProductImg;
import com.yuhan.repository.OrderProductRepository;
import com.yuhan.repository.OrderRepository;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderProductService {
	private final OrderProductRepository orderProductRepository;
	
	public List<OrderProduct> findUsername(String name){
		return orderProductRepository.findByProductName(name);
	}
	
	public List<OrderProductDto> getOrderProductDtl(String username) {
		List<OrderProduct> orderProductList = orderProductRepository.findByUserName(username);
		List<OrderProductDto> orderProductDtoList = new ArrayList<>();
		
		for (OrderProduct orderProduct : orderProductList) {
			OrderProductDto orderProductDto = OrderProductDto.of(orderProduct);
			orderProductDtoList.add(orderProductDto);
		}
		
		return orderProductDtoList;
	}
}
