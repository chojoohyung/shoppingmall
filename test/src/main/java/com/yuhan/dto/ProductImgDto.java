package com.yuhan.dto;

import org.modelmapper.ModelMapper;

import com.yuhan.entity.ProductImg;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductImgDto {
	private int id;
	
	private String imgName;
	
	private String imgUrl;
	
	private static ModelMapper modelMappler = new ModelMapper();
	
	public static ProductImgDto of(ProductImg productImge) {
		return modelMappler.map(productImge, ProductImgDto.class);
	}
	
	
}
