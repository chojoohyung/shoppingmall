package com.yuhan.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.yuhan.constant.Size;
import com.yuhan.entity.Product;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDto {
	
	private Long id;
	
	@NotBlank(message = "상품명 필수 입력")
	private String name;
	
	@NotNull(message = "가격 필수 입력")
	private Integer price;
	
	@NotNull(message = "재고 필수 입력")
	private Integer stock;
	
	private String color;
	
	private Size size;
	
	private String category;
	
	private List<ProductImgDto> productImgDtoList = new ArrayList<>();
	
	private List<Long> productImgIds = new ArrayList<>();
	
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Product createProduct() {
		return modelMapper.map(this, Product.class);
	}
	
	public static ProductDto of(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}
	
}
