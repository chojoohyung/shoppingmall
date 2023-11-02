package com.yuhan.dto;

import com.yuhan.constant.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CartDetailDto {

	private Long cartProductId;
	
	private String name;
	
	private int price;
	
	private Size size;
	
	private String color;
	
	private int count;
	
	private String imgUrl;
	
	private Long productId;
	
	public CartDetailDto(Long cartProductId, String name, int price, Size size, String color, int count, String imgUrl, Long productId) {
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
