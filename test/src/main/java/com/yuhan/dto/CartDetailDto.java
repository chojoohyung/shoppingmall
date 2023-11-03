package com.yuhan.dto;

import lombok.Data;

@Data
public class CartDetailDto {

	private Long cartProductId;
	
	private String name;
	
	private int price;
	
	private String size;
	
	private String color;
	
	private int count;
	
	private String imgUrl;
	
	private Long productId;
	
	public CartDetailDto(Long cartProductId, String name, int price, String size, String color, int count, String imgUrl, Long productId) {
		this.cartProductId = cartProductId;
		this.name = name;
		this.price = price;
		this.size = size;
		this.color = color;
		this.count = count;
		this.imgUrl = imgUrl;
		this.productId = productId;
		
	}
}
