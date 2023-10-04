package com.yuhan.dto;

import org.modelmapper.ModelMapper;

import com.yuhan.entity.ProductImg;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductImgDto {
	private Long id;

	private String oriImgName;
	
	private String imgName;
	
	private String imgUrl;
	
	private static ModelMapper modelMappler = new ModelMapper();
	
	public static ProductImgDto of(ProductImg productImge) {
		return modelMappler.map(productImge, ProductImgDto.class);
	}
	
	
}
