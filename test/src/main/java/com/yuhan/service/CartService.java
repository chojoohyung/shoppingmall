package com.yuhan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.yuhan.dto.CartDetailDto;
import com.yuhan.dto.CartOrderDto;
import com.yuhan.dto.CartProductDto;
import com.yuhan.dto.OrderDto;
import com.yuhan.entity.Cart;
import com.yuhan.entity.CartProduct;
import com.yuhan.entity.Product;
import com.yuhan.entity.User;
import com.yuhan.repository.CartProductRepository;
import com.yuhan.repository.CartRepository;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final CartRepository cartRepository;
	private final CartProductRepository cartProductRepository;
	private final OrderService orderService;
	
	public Long addCart(CartProductDto cartProductDto, String username) {
		Product product = productRepository.findById(cartProductDto.getProductId()).orElseThrow(EntityNotFoundException::new);
		User user = userRepository.findByUsername(username);
		
		Cart cart = cartRepository.findByUserId(user.getId());
		if(cart == null) {
			cart =Cart.createCart(user);
			cartRepository.save(cart);
		}
		
		CartProduct saveCartProduct = cartProductRepository.findByCartIdAndProductId(cart.getId(), product.getId());
		
		if(saveCartProduct != null) {
			saveCartProduct.addCount(cartProductDto.getCount());
			return saveCartProduct.getId();
		}else {
			CartProduct cartProduct = CartProduct.createCartProduct(cart, product, cartProductDto.getCount());
			cartProductRepository.save(cartProduct);
			return cartProduct.getId();
		}
	}
	
	@Transactional(readOnly = true)
	public List<CartDetailDto> getCartList(String username){
		
		List<CartDetailDto> cartDetailDtoList = new ArrayList<>();
		
		User user = userRepository.findByUsername(username);
		Cart cart = cartRepository.findByUserId(user.getId());
		if(cart == null) {
			return cartDetailDtoList;
		}
		
		cartDetailDtoList = cartProductRepository.findCartDetailDtoList(cart.getId());
		return cartDetailDtoList;
		
		
	}
	
	@Transactional(readOnly = true)
	public boolean validateCartProduct(Long cartProductId, String username) {
		User user = userRepository.findByUsername(username);
		CartProduct cartProduct = cartProductRepository.findById(cartProductId).orElseThrow(EntityNotFoundException::new);
		User savedUser = cartProduct.getCart().getUser();
		
		if(!StringUtils.equals(user.getUsername(), savedUser.getUsername())) {
			return false;
		}
		
		return true;
		
	}
	
	public void updateCartProductCount(Long cartProductId, int count) {
		CartProduct cartProduct = cartProductRepository.findById(cartProductId).orElseThrow(EntityNotFoundException::new);
		cartProduct.updateCount(count);
	}
	
	public void deleteCartProduct(Long cartProductId) {
		CartProduct cartProduct = cartProductRepository.findById(cartProductId).orElseThrow(EntityNotFoundException::new);
		cartProductRepository.delete(cartProduct);
	}
	
	public Long orderCartProduct(List<CartOrderDto> cartOrderDtoList, String username) {
		
		List<OrderDto> orderDtoList = new ArrayList<>();
		for (CartOrderDto cartOrderDto : cartOrderDtoList) {
			CartProduct cartProduct = cartProductRepository.findById(cartOrderDto.getCartProductId()).orElseThrow(EntityNotFoundException::new);
			
			OrderDto orderDto = new OrderDto();
			orderDto.setId(cartProduct.getProduct().getId());
			orderDto.setCount(cartProduct.getCount());
			orderDtoList.add(orderDto);
		}
		
		Long orderId = orderService.orders(orderDtoList, username);
		
		for (CartOrderDto cartOrderDto : cartOrderDtoList) {
			CartProduct cartProduct = cartProductRepository.findById(cartOrderDto.getCartProductId()).orElseThrow(EntityNotFoundException::new);
			cartProductRepository.delete(cartProduct);
		}
		
		return orderId;
	}
}
