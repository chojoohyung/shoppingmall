package com.yuhan.dto;

import com.yuhan.constant.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartDetailDto {

	private Long cartProductId;
	
	private String name;
	
	private int price;
	
	private Size size;
	
	private String color;
	
	private int count;
	
	private String imgUrl;
	
	public CartDetailDto(Long cartProductId, String name, int price, Size size, String color, int count, String imgUrl) {
		this.cartProductId = cartProductId;
		this.name = name;
		this.price = price;
		this.size = size;
		this.color = color;
		this.count = count;
		this.imgUrl = imgUrl;
		
	}
}
