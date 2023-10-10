package com.yuhan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yuhan.dto.OrderProductDto;
import com.yuhan.dto.ProductDto;
import com.yuhan.dto.UsedFormDto;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;
import com.yuhan.entity.Used;
import com.yuhan.repository.OrderProductRepository;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.UsedRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsedService {
	private final UsedRepository usedRepository;
	private final ProductRepository productRepository;
	private final OrderProductRepository orderProductRepository;
	
	public Long save(UsedFormDto usedFormDto) throws Exception {
		Used used = usedFormDto.createUsed();
		usedRepository.save(used);
		return used.getId();
	}
	
	public List<Used> findAll(){
		List<Used> usedList = usedRepository.findAll();
		
		return usedList;
	}
	//OrderProduct 안에 product 매핑
	public UsedFormDto getProductDtl(String username) {
		List<OrderProduct> orderProductList = orderProductRepository.findOrderProductByUserName(username);
		List<OrderProductDto> orderProductDtoList = new ArrayList<>();
		
		for (OrderProduct orderProduct : orderProductList) {
			
			List<ProductDto> productDtoList = new ArrayList<>();
			Product product = productRepository.getById(orderProduct.getProduct().getId());
			orderProduct.setProduct(product);
			OrderProductDto orderProductDto = OrderProductDto.of(orderProduct);
			orderProductDtoList.add(orderProductDto);
		}
		UsedFormDto usedFormDto = new UsedFormDto();
		usedFormDto.setOrderProductDtoList(orderProductDtoList);
		
		return usedFormDto;
	}
	
	public Used getDtl(Long id) throws Exception {
		Used used = usedRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		
		return used;
	}
	
}
