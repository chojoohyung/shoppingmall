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
	
	/*
	 * ModelMapper : Entity와 Dto간의 같은필드 값 매핑
	 */
	private static ModelMapper modelMapper = new ModelMapper();
	
	/*
	 * Entity <- Dto
	 * Entity entity = Dto.createEntity();
	 */
	public Product createProduct() {
		return modelMapper.map(this, Product.class);
	}
	
	/*
	 * Dto <- Entity
	 * Dto dto = Dto.of(entity)
	 */
	public static ProductDto of(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}
	
}
