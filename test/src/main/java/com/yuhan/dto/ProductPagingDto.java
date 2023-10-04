package com.yuhan.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.yuhan.constant.Size;
import com.yuhan.entity.Product;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductPagingDto {
	
	private Long id;
	
	private String name;
	
	private Integer price;
	
	private Integer stock;
	
	private String color;
	
	private Size size;
	
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
