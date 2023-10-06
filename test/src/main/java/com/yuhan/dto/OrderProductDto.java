package com.yuhan.dto;

import com.yuhan.entity.OrderProduct;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderProductDto {
	
	
	
	public OrderProductDto(Long id, String imgUrl) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.orderPrice = orderPrice;
		this.imgUrl = imgUrl;
	}
	private Long id;
	private String name;
	private int count;
	private int orderPrice;
	private String imgUrl;
}
