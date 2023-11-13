package com.yuhan.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yuhan.dto.OrderProductDto;
import com.yuhan.dto.ProductDto;
import com.yuhan.dto.ProductImgDto;
import com.yuhan.dto.UsedFormDto;
import com.yuhan.dto.UsedImgDto;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;
import com.yuhan.entity.ProductImg;
import com.yuhan.entity.Used;
import com.yuhan.entity.UsedImg;
import com.yuhan.repository.OrderProductRepository;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.UsedImgRepository;
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
	private final UsedImgRepository usedImgRepository;
	
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
	
	public UsedFormDto getUsedDtl(Long id) {
		List<UsedImg> usedImgList = usedImgRepository.findByUsedIdOrderByIdAsc(id);
		List<UsedImgDto> usedImgDtoList = new ArrayList<>();
		
		for (UsedImg usedImg : usedImgList) {
			UsedImgDto usedImgDto = UsedImgDto.of(usedImg);
			usedImgDtoList.add(usedImgDto);
		}
		
		//상품 id를 통해 상품조회, 없을시 Exception 발생
		Used used = usedRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		UsedFormDto usedFormDto = UsedFormDto.of(used);
		usedFormDto.setUsedImgDtoList(usedImgDtoList);
		
		return usedFormDto;
	}
	
	
	public List<Used> getPIDUsedList(Long id) {
		Product product = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		
		List<Used> PIDUsedList = new ArrayList<>();
		
		List<OrderProduct> orderProductList = orderProductRepository.findByProduct(product);
		for (OrderProduct orderProduct : orderProductList) {
			List<Used> usedList = usedRepository.findByOrderProduct(orderProduct);
			PIDUsedList.addAll(usedList);
		}
		Collections.sort(PIDUsedList, Comparator.comparing(Used::getCreateDate).reversed());
		
		return PIDUsedList;
	}
	
	public Page<Used> findByOrderProduct_Order_User_username(Pageable pageable, String username){
		return usedRepository.findByOrderProduct_Order_User_username(pageable, username);
	}
	
	public void delete(Used used) {
		usedRepository.delete(used);
	}
	
}
