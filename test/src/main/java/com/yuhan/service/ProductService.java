package com.yuhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.yuhan.dto.ProductDto;
import com.yuhan.entity.Product;
import com.yuhan.entity.ProductImg;
import com.yuhan.repository.ProductImgRepository;
import com.yuhan.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

	private final ProductRepository productRepository;
	private final ProductImgService productImgService;
	private final ProductImgRepository productImgRepository;
	
	public int saveProduct(ProductDto productDto, List<MultipartFile> productImgFileList) throws Exception{
		
		//상품 등록
		Product product = productDto.createProduct();
		productRepository.save(product);
		
		//이미지 등록
		for (int i = 0; i < productImgFileList.size(); i++) {
			ProductImg productImg = new ProductImg();
			productImg.setProduct(product);
			
			productImgService.saveProductImg(productImg, productImgFileList.get(i));
			
		}
		return product.getId();
	}
	
	
}
