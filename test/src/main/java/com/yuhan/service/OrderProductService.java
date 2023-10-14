package com.yuhan.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhan.repository.OrderProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderProductService {
	private final OrderProductRepository orderProductRepository;
	
	
	
}
