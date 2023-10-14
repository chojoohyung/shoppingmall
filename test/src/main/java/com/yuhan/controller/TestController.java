package com.yuhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
/*
 * 현재 구현안된 나머지 모아놓은 컨트롤러
 */
public class TestController {
	

	
	@GetMapping("/protected/mypage")
	public String mypage() {
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
