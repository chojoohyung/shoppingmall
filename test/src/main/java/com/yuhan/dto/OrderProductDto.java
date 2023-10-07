package com.yuhan.dto;

import org.modelmapper.ModelMapper;

import com.yuhan.entity.Order;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderProductDto {
	
	private Long id;
	private Order order;
	private Product product;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public OrderProduct createOrderProduct() {
		return modelMapper.map(this, OrderProduct.class);
	}
	
	public static OrderProductDto of(OrderProduct orderProduct) {
		OrderProductDto orderProductDto = modelMapper.map(orderProduct, OrderProductDto.class);
        
        // ProductDto에 Product.name 값을 저장
        Product product = new Product();
        product.setName(orderProduct.getProduct().getName());
        orderProductDto.setProduct(product);
        
        return orderProductDto;
	}
}
