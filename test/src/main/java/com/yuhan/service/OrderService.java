package com.yuhan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yuhan.dto.OrderDto;
import com.yuhan.entity.Order;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;
import com.yuhan.entity.User;
import com.yuhan.repository.OrderRepository;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final OrderRepository orderRepository;
	
	public Long order(OrderDto orderDto, String username) {
		Product product = productRepository.findById(orderDto.getProductId()).orElseThrow(EntityNotFoundException::new);
		User user = userRepository.findByUsername(username);
		
		List<OrderProduct> orderProductList = new ArrayList<>();
		OrderProduct orderProduct = OrderProduct.createOrderProduct(product, orderDto.getCount());
		orderProductList.add(orderProduct);
		
		Order order = Order.createOrder(user, orderProductList);
		orderRepository.save(order);
		
		return order.getId();
		
		
		
		
	}
	
}
