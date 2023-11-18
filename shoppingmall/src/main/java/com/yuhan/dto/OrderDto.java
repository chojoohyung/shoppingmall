package com.yuhan.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.yuhan.entity.Order;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;
import com.yuhan.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDto {
	
	private Long id;
	private int count;
	private LocalDateTime orderDate; 
	
	/*
	 * ModelMapper : Entity와 Dto간의 같은필드 값 매핑
	 */
	private static ModelMapper modelMapper = new ModelMapper();
	
	/*
	 * Entity <- Dto
	 * Entity entity = Dto.createEntity();
	 */
	public Order createOrder() {
		return modelMapper.map(this, Order.class);
	}
	
	/*
	 * Dto <- Entity
	 * Dto dto = Dto.of(entity)
	 */
	public static OrderDto of(Order order) {
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        return orderDto;
	}
}
