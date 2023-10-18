package com.yuhan.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuhan.dto.CartDetailDto;
import com.yuhan.dto.CartOrderDto;
import com.yuhan.dto.CartProductDto;
import com.yuhan.service.CartService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {
	
	private final CartService cartService;
	
	@PostMapping("/cart")
	public @ResponseBody ResponseEntity order(@RequestBody @Valid CartProductDto cartProductDto, BindingResult bindingResult, Principal principal) {
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				sb.append(fieldError.getDefaultMessage());
			}
			return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
		}
		
		String username = principal.getName();
		Long cartProductId;
		
		try {
			cartProductId = cartService.addCart(cartProductDto, username);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Long>(cartProductId, HttpStatus.OK);
	}
	
	@GetMapping("/protected/cart")
	public String orderList(Principal principal, Model model) {
		List<CartDetailDto> cartDetailDtoList = cartService.getCartList(principal.getName());

		for (CartDetailDto cartDetailDto : cartDetailDtoList) {
			System.out.println(cartDetailDto.getSize().toString());
		}
		
		model.addAttribute("cartDetailDtoList", cartDetailDtoList);
		return "/protected/cart";
	}
	
	@PatchMapping(value = "/cartProduct/{cartProductId}")
	public @ResponseBody ResponseEntity updateCartProduct(@PathVariable("cartProductId") Long cartProductId, int count, Principal principal) {
		if(count <= 0) {
			return new ResponseEntity<String>("최소 1개", HttpStatus.BAD_REQUEST);
		}else if(!cartService.validateCartProduct(cartProductId, principal.getName())) {
			return new ResponseEntity<String>("수정권한 X", HttpStatus.FORBIDDEN);
		}
		
		cartService.updateCartProductCount(cartProductId, count);

		
		return new ResponseEntity<Long>(cartProductId, HttpStatus.OK);
	}
	
	@DeleteMapping("/cartProduct/{cartProductId}")
	public @ResponseBody ResponseEntity deleteCartProduct(@PathVariable("cartProductId") Long cartProductId, Principal principal) {
		if(!cartService.validateCartProduct(cartProductId, principal.getName())) {
			return new ResponseEntity<String>("수정권한 X", HttpStatus.FORBIDDEN);
		}
		cartService.deleteCartProduct(cartProductId);
		return new ResponseEntity<Long>(cartProductId, HttpStatus.OK);
	}
	
	@PostMapping("/protected/cart/orders")
	public @ResponseBody ResponseEntity orderCartProduct(@RequestBody CartOrderDto cartOrderDto, Principal principal) {
	
		List<CartOrderDto> cartOrderDtoList = cartOrderDto.getCartOrderDtoList();
		
		if(cartOrderDtoList == null || cartOrderDtoList.size() == 0) {
			return new ResponseEntity<String>("주문 상품 선택", HttpStatus.FORBIDDEN);
		}
		
		for (CartOrderDto cartOrder : cartOrderDtoList) {
			if(!cartService.validateCartProduct(cartOrder.getCartProductId(), principal.getName())) {
				return new ResponseEntity<String>("주문 권한이 없습니다", HttpStatus.FORBIDDEN);
			}
		}
		
		Long orderId = cartService.orderCartProduct(cartOrderDtoList, principal.getName());
		return new ResponseEntity<Long>(orderId, HttpStatus.OK);
	
	}
}
