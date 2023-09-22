package com.yuhan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yuhan.model.Product;
import com.yuhan.model.Qa;
import com.yuhan.model.User;
import com.yuhan.model.Jproduct;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	@GetMapping("/fragments/header")
	public String header(User user) {
		return "/fragments/header";
	}
	
	@GetMapping("/public/hello")
	public String hello(User user) {
		return "/public/hello";
	}
	
	@GetMapping("/public/productList")
	public String productList(User user, Model model) {
		
		List<List<Product>> plist = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			List<Product> plistItem = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				Product product = new Product();
				product.setImg("../../resources/img/{6E8F3DA7-4F8C-4BDF-85F6-962AF83FF710}.png");
				product.setName("흰티");
				product.setPrice((j+1)*10000);
				product.setUrl("/");
				plistItem.add(product);
				
			}
			plist.add(plistItem);
		}
		
		
		model.addAttribute("plist", plist);
		
		
		return "/public/productList";
	}
	
	@GetMapping("/public/faq")
	public String qa(User user, Model model) {
		
		List<Qa> qalist = new ArrayList<>();
		
		Qa qa = new Qa();
		qa.setPostId(0);
		qa.setTitle("고객센터");
		qa.setContent("기다리세요");
				
		Qa qa2 = new Qa();
		qa2.setPostId(1);
		qa2.setTitle("결제언제됌");
		qa2.setContent("내일이요");
		
		qalist.add(qa);
		qalist.add(qa2);
		
		
		model.addAttribute("qalist", qalist);
		
		
		return "/public/faq";
	}
	
	@GetMapping("/public/Jproduct")
	public String JproductPage(Model model) {

	    List<List<Jproduct>> plist = new ArrayList<>();

	    for (int i = 0; i < 2; i++) {
	        List<Jproduct> plistItem = new ArrayList<>();
	        for (int j = 0; j < 5; j++) {
	            Jproduct jproduct = new Jproduct();
	            if (j % 2 == 0) {
	                jproduct.setImg("img/hi.png");
	            } else {
	                jproduct.setImg("img/h2.png");
	            }
	           // jproduct.setImg("img/hi.png");
	            jproduct.setName("이름" + j);  // 각 제품마다 다른 이름
	            jproduct.setPrice((j + 1) * 10000);
	            jproduct.setUrl("/products");
	            plistItem.add(jproduct);
	        }
	       
	        plist.add(plistItem);
	    }
	    model.addAttribute("plist", plist);

	    return "/public/Jproduct";
	}
	
	
	//------------------------------------------------------------
	
	
	@GetMapping("/protected/mypage")
	public String mypage(User user, Model model) {
		Product product = new Product();
		product.setImg("../../resources/img/{6E8F3DA7-4F8C-4BDF-85F6-962AF83FF710}.png");
		
		Product product2 = new Product();
		product2.setImg("../../resources/img/{5712D152-214F-4503-BA02-79971EB7682C}.png");
		
		
		List<Product> plist = new ArrayList<>();
		plist.add(product);
		plist.add(product2);
		
		
		model.addAttribute("plist", plist);
		
		
		return "/protected/mypage";
	}
	
	@GetMapping("/protected/membership")
	public String membership(User user) {
		
		return "/protected/membership";
	}
	
	@GetMapping("/protected/coupon")
	public String coupon(User user) {
		return "/protected/coupon";
	}
	
	@GetMapping("/protected/change")
	public String change(User user) {
		return "/protected/change";
	}
	
	@GetMapping("/protected/order")
	public String order(User user) {
		return "/protected/order";
	}
	@GetMapping("/protected/cs")
	public String product(Model model, Product products) {
		return "/protected/cs";
	}
	@GetMapping("/protected/cart")
	public String cart(Model model, Product products) {
		return "/protected/cart";
	}
	@GetMapping("/protected/cart2")
	public String cart2(Model model, Product products) {
		return "/protected/cart2";
	}
	
}
