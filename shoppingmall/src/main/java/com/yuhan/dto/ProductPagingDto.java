package com.yuhan.dto;

import org.modelmapper.ModelMapper;

import com.yuhan.entity.Product;

import lombok.Data;

@Data
public class ProductPagingDto {
	
	private Long id;
	
	private String name;
	
	private Integer price;
	
	private Integer stock;
	
	private String color;
	
	private String size;
	
	private String category;
	
	private ProductImgDto productImgDto = new ProductImgDto();
	
	private Long productImgId;
	
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Product createProduct() {
		return modelMapper.map(this, Product.class);
	}
	
	public static ProductPagingDto of(Product product) {
		return modelMapper.map(product, ProductPagingDto.class);
	}
	
}
