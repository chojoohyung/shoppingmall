package com.yuhan.dto;

import org.modelmapper.ModelMapper;

import com.yuhan.constant.Size;
import com.yuhan.entity.Product;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDto {
	private int id;
	
	@NotBlank(message = "상품명 필수 입력")
	private String name;
	
	@NotBlank(message = "가격 필수 입력")
	private int price;
	
	@NotBlank(message = "색상 필수 입력")
	private String color;
	
	
	private Size size;
	
	
	private int stock;
	
	
	private String category;
	
	
	private ProductImgDto productImgDto = new ProductImgDto();
	
	
	private int productImgId;
	
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Product createProduct() {
		return modelMapper.map(this, Product.class);
	}
	
	public static ProductDto of(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}
	
}
