package com.yuhan.dto;

import org.modelmapper.ModelMapper;

import com.yuhan.entity.OrderProduct;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderProductDto {
	
	private Long id;
	private int orderPrice;
	private int count;
	private OrderDto order;
	private ProductDto product;
	
	/*
	 * ModelMapper : Entity와 Dto간의 같은필드 값 매핑
	 */
	private static ModelMapper modelMapper = new ModelMapper();
	
	/*
	 * Entity <- Dto
	 * Entity entity = Dto.createEntity();
	 */
	public OrderProduct createOrderProduct() {
		return modelMapper.map(this, OrderProduct.class);
	}
	
	/*
	 * Dto <- Entity
	 * Dto dto = Dto.of(entity)
	 */
	public static OrderProductDto of(OrderProduct orderProduct) {
		OrderProductDto orderProductDto = modelMapper.map(orderProduct, OrderProductDto.class);
        return orderProductDto;
	}
}
