package com.yuhan.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuhan.dto.OrderFormDto;
import com.yuhan.entity.Order;
import com.yuhan.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;
	
	/*
	 * User용 유저 주문내역 리스트
	 */
	@GetMapping("/protected/order")
	public String orderUser(Model model, Principal principal) {
		
		List<Order> orders = orderService.findUsername(principal.getName());
		model.addAttribute("orders", orders);
	
		return "/protected/order";
	}
	
	/*
	 * Admin용 모든 주문내역 리스트
	 */
	@GetMapping("/admin/order")
	public String orderAdmin(Model model) {
		List<Order> orders = orderService.findAll();
		model.addAttribute("orders", orders);
		return "/protected/order";
	}
	
	
	/*
	 * 주문 시 동작할 컨트롤러
	 */
	@PostMapping("/order")
	public @ResponseBody ResponseEntity order(@RequestBody @Valid OrderFormDto orderDto, BindingResult bindingResult, Principal principal) {
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				sb.append(fieldError.getDefaultMessage());
			}
			return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
		}
		String username = principal.getName();
		Long orderId;
		try {
			orderId = orderService.order(orderDto, username); 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Long>(orderId, HttpStatus.OK);
	}
}