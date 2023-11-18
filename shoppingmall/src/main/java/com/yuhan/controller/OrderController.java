package com.yuhan.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuhan.dto.OrderFormDto;
import com.yuhan.dto.ProductDto;
import com.yuhan.entity.Order;
import com.yuhan.service.OrderService;
import com.yuhan.service.ProductService;
import com.yuhan.service.RecommendService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;
	private final ProductService productService;
	private final RecommendService recommendService;
	/*
	 * User용 유저 주문내역 리스트
	 */
	@GetMapping(value = {"/protected/order/{page}", "/protected/order"})
	public String orderUser(Model model, Principal principal, @PathVariable("page") Optional<Integer> page) {
		
		int pageSize = 10; // 페이지당 항목 수
	    int defaultPage = 0; // 기본 페이지 번호

	    if (page.isPresent()) {
	        if (page.get() < 0) {
	            // 페이지 번호가 0 미만인 경우 기본 페이지 번호로 설정
	            page = Optional.of(defaultPage);
	        }
	    } else {
	        page = Optional.of(defaultPage);
	    }

	    Pageable pageable = PageRequest.of(page.get(), pageSize);
	    
		Page<Order> orders = orderService.findUsername(pageable, principal.getName());
		int totalPages = orders.getTotalPages() - 1; // 전체 페이지 수
		
		model.addAttribute("totalPages", totalPages);
	    model.addAttribute("page", page.orElse(defaultPage)); // 현재 페이지 번호
		model.addAttribute("orders", orders);
		return "/protected/order";
	}
	
	/*
	 * Admin용 모든 주문내역 리스트
	 */
	@GetMapping(value = {"/admin/order/{page}", "/admin/order"})
	public String orderAdmin(Model model, @PathVariable("page") Optional<Integer> page) {
		
		int pageSize = 10; // 페이지당 항목 수
	    int defaultPage = 0; // 기본 페이지 번호

	    if (page.isPresent()) {
	        if (page.get() < 0) {
	            // 페이지 번호가 0 미만인 경우 기본 페이지 번호로 설정
	            page = Optional.of(defaultPage);
	        }
	    } else {
	        page = Optional.of(defaultPage);
	    }

	    Pageable pageable = PageRequest.of(page.get(), pageSize);
		
		Page<Order> orders = orderService.findAllByOrderByOrderDateDesc(pageable);
		List<ProductDto> productDtoList = new ArrayList<>();
		for (Order order : orders) {
			ProductDto productDto = productService.getProductDtl(order.getOrderProducts().get(0).getProduct().getId());
			productDtoList.add(productDto);
		}
		
		int totalPages = orders.getTotalPages() - 1; // 전체 페이지 수
		
		model.addAttribute("totalPages", totalPages);
	    model.addAttribute("page", page.orElse(defaultPage)); // 현재 페이지 번호
		model.addAttribute("orders", orders);
		model.addAttribute("productDtoList", productDtoList);
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
			recommendService.updateRecommend(orderDto.getProductId(), principal.getName(), 5*orderDto.getCount());
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Long>(orderId, HttpStatus.OK);
	}
}
