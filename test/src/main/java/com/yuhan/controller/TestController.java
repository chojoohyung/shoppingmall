package com.yuhan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yuhan.entity.Qa;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
/*
 * 현재 구현안된 나머지 모아놓은 컨트롤러
 */
public class TestController {
	
	@GetMapping("/public/faq")
	public String qa(Model model) {
		List<Qa> qalist = new ArrayList<>();

		
		for (int i = 0; i < 7; i++) {
			Qa qa = new Qa();
			qa.setPostId(0L);
			qa.setTitle("환불언제됌");
			qa.setContent("내일이요");
			qalist.add(qa);
		}
		
		
		model.addAttribute("qalist", qalist);
		
		return "/public/faq";
	}
	
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
	

	
	@GetMapping("/protected/cart")
	public String cart() {
		return "/protected/cart";
	}
	
	@GetMapping("/protected/orderchange")
	public String orderchange() {
		return "/protected/orderchange";
	}
}
