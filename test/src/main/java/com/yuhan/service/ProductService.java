package com.yuhan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yuhan.dto.ProductDto;
import com.yuhan.dto.ProductImgDto;
import com.yuhan.entity.Product;
import com.yuhan.entity.ProductImg;
import com.yuhan.repository.ProductImgRepository;
import com.yuhan.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

	private final ProductRepository productRepository;
	private final ProductImgService productImgService;
	private final ProductImgRepository productImgRepository;
	
	public Long saveProduct(ProductDto productDto, List<MultipartFile> productImgFileList) throws Exception{
		
		//상품 등록
		Product product = productDto.createProduct();
		product.setIs_delete(false);
		productRepository.save(product);
		
		//이미지 등록
		for (int i = 0; i < productImgFileList.size(); i++) {
			ProductImg productImg = new ProductImg();
			productImg.setProduct(product);
			
			productImgService.saveProductImg(productImg, productImgFileList.get(i));
			
		}
		return product.getId();
	}
	
	@Transactional(readOnly = true)
	public ProductDto getProductDtl(Long id) {
		List<ProductImg> productImgList = productImgRepository.findByProductIdOrderByIdAsc(id);
		List<ProductImgDto> productImgDtoList = new ArrayList<>();
		
		for (ProductImg productImg : productImgList) {
			ProductImgDto productImgDto = ProductImgDto.of(productImg);
			productImgDtoList.add(productImgDto);
		}
		
		//상품 id를 통해 상품조회, 없을시 Exception 발생
		Product product = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		ProductDto productDto = ProductDto.of(product);
		productDto.setProductImgDtoList(productImgDtoList);
		return productDto;
		
	}
	
	public Long updateProduct(ProductDto productDto, List<MultipartFile> productImgFileList) throws Exception{
		
		//상품 수정
		Product product = productRepository.findById(productDto.getId()).orElseThrow(EntityNotFoundException::new);
		product.updateProduct(productDto);
		
		List<Long> productImgIds = productDto.getProductImgIds();
		
		
		//이미지 등록
		for (int i = 0; i < productImgFileList.size(); i++) {
			productImgService.updateProductImg(productImgIds.get(i), productImgFileList.get(i));
		}
		return product.getId();
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<ProductDto> test(Pageable pageable) {
		List<ProductDto> productDtos = new ArrayList<>();
		
		List<Product> productList = productRepository.queryAnnotion(pageable);
		
		for (int i = 0; i < productList.size(); i++) {
			productDtos.add(getProductDtl(productList.get(i).getId()));
		}
		
		
		return productDtos;
	}
	
	@Transactional(readOnly = true)
	public List<ProductDto> findcategory(Pageable pageable, String category) {
		List<ProductDto> productDtos = new ArrayList<>();
		
		List<Product> productList = productRepository.catogoryfind(pageable, category);
		
		for (int i = 0; i < productList.size(); i++) {
			productDtos.add(getProductDtl(productList.get(i).getId()));
		}
		
		
		return productDtos;
	}
	
	public String findIdByName(Long id) {
		return productRepository.findIdByName(id);
	}
	
	public void delete(Long id) {
		Product product = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		product.setIs_delete(true);
		productRepository.save(product);
	}
}
