package com.yuhan.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yuhan.dto.CartDetailDto;
import com.yuhan.service.CartService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
/*
 * 현재 구현안된 나머지 모아놓은 컨트롤러
 */
public class TestController {

	private final CartService cartService;

	@GetMapping("/protected/mypage")
	public String mypage(Principal principal, Model model) {
		List<CartDetailDto> cartDetailDtoList = cartService.getCartList(principal.getName());
		model.addAttribute("cartDetailDtoList", cartDetailDtoList);
		return "/protected/mypage";
	}

	@GetMapping("/protected/membership")
	public String membership() {

		return "/protected/membership";
	}

	@GetMapping("/protected/coupon")
	public String coupon() {
		return "/protected/coupon";
	}

	@GetMapping("/protected/change")
	public String change() {
		return "/protected/change";
	}

	@GetMapping("/protected/orderchange")
	public String orderchange() {
		return "/protected/orderchange";
	}
}
