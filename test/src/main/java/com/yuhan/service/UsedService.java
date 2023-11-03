package com.yuhan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yuhan.dto.OrderProductDto;
import com.yuhan.dto.ProductDto;
import com.yuhan.dto.UsedFormDto;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;
import com.yuhan.entity.ProductImg;
import com.yuhan.entity.Used;
import com.yuhan.entity.UsedImg;
import com.yuhan.repository.OrderProductRepository;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.UsedRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsedService {
	private final UsedRepository usedRepository;
	private final ProductRepository productRepository;
	private final OrderProductRepository orderProductRepository;
	private final UsedImgService usedImgService;
	
	public Long save(UsedFormDto usedFormDto, List<MultipartFile> usedImgFileList) throws Exception {
		
		//중고 글 등록
		Used used = usedFormDto.createUsed();
		usedRepository.save(used);
		
		//이미지 등록
		for (int i = 0; i < usedImgFileList.size(); i++) {
			UsedImg usedImg = new UsedImg();
			usedImg.setUsed(used);
			
			usedImgService.saveUsedImg(usedImg, usedImgFileList.get(i));
			
		}
		return used.getId();
	}
	
	@Transactional(readOnly = true)
	public Page<Used> test(Pageable pageable) {
		Page<Used> usedList = usedRepository.queryAnnotion(pageable);
		return usedList;
	}
	
	public List<Used> findAll(){
		List<Used> usedList = usedRepository.findByOrderByIdDesc();
		
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
