package com.yuhan.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yuhan.dto.OrderProductDto;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.User;
import com.yuhan.service.OrderProductService;
import com.yuhan.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JProductController {
	private final OrderService orderService;
	private final OrderProductService orderProductService;
	
	@GetMapping("/protected/JproductForm")
	public String JproductForm(Model model, Principal principal) {
		/*
		List<OrderProduct> orderProducts = orderProductService.findUsername(principal.getName());
		model.addAttribute("orders", orderProducts);*/
		List<OrderProductDto> orderProductDtoList = orderProductService.getOrderProductDtl(principal.getName());
		model.addAttribute("orderProductDtoList", orderProductDtoList);
		
		return "/protected/JproductForm";
	}
	
	@GetMapping("/public/Jproduct")
	public String JproductPage(Model model) {
	    return "/public/Jproduct";
	}
}
