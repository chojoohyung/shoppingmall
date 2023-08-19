package com.yuhan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yuhan.model.Product;
import com.yuhan.model.Qa;
import com.yuhan.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	@GetMapping("/mypage")
	public String mypage(User user, Model model) {
		Product product = new Product();
		product.setImg("../../resources/img/{6E8F3DA7-4F8C-4BDF-85F6-962AF83FF710}.png");
		
		Product product2 = new Product();
		product2.setImg("../../resources/img/{5712D152-214F-4503-BA02-79971EB7682C}.png");
		
		
		List<Product> plist = new ArrayList<>();
		plist.add(product);
		plist.add(product2);
		
		
		model.addAttribute("plist", plist);
		
		
		return "/mypage";
	}
	
	@GetMapping("/membership")
	public String membership(User user) {
		
		return "/membership";
	}
	
	@GetMapping("/coupon")
	public String coupon(User user) {
		return "/coupon";
	}
	
	@GetMapping("/order")
	public String order(User user) {
		return "/order";
	}
	@GetMapping("/fragments/header")
	public String header(User user) {
		return "/fragments/header";
	}
	
	@GetMapping("/productList")
	public String productList(User user, Model model) {
		
		List<List<Product>> plist = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			List<Product> plistItem = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				Product product = new Product();
				product.setImg("../../resources/img/{6E8F3DA7-4F8C-4BDF-85F6-962AF83FF710}.png");
				product.setName("흰티");
				product.setPrice((j+1)*10000);
				product.setUrl("/hello");
				plistItem.add(product);
				
			}
			plist.add(plistItem);
		}
		
		
		model.addAttribute("plist", plist);
		
		
		return "/productList";
	}
	
	@GetMapping("/qa")
	public String qa(User user, Model model) {
		
		List<Qa> qalist = new ArrayList<>();
		
		Qa qa = new Qa();
		qa.setPostId(0);
		qa.setTitle("환불언제됌");
		qa.setContent("내일이요");
		
		Qa qa2 = new Qa();
		qa2.setPostId(1);
		qa2.setTitle("결제언제됌");
		qa2.setContent("내일이요");
		
		qalist.add(qa);
		qalist.add(qa2);
		
		
		model.addAttribute("qalist", qalist);
		
		
		return "/qa";
	}
	
}