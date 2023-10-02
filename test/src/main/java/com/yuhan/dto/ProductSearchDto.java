package com.yuhan.dto;

import com.yuhan.constant.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductSearchDto {
	
	private Long id;
	
	private String name;
	
	private String color;
	
	private Size size;
	
	private String category;
	
	
}
