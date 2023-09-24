package com.yuhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	@GetMapping("/fragments/header")
	public String header() {
		return "/fragments/header";
	}
	
	@GetMapping("/admin/ProductForm")
	public String ProductForm() {
		return "/admin/ProductForm";
	}
	
	@GetMapping("/public/productList")
	public String productList(Model model) {
		/*
		List<List<ProductModel>> plist = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			List<ProductModel> plistItem = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				ProductModel product = new ProductModel();
				product.setImg("../../resources/img/{6E8F3DA7-4F8C-4BDF-85F6-962AF83FF710}.png");
				product.setName("흰티");
				product.setPrice((j+1)*10000);
				product.setUrl("/");
				plistItem.add(product);
				
			}
			plist.add(plistItem);
		}
		
		
		model.addAttribute("plist", plist);
		*/
		
		return "/public/productList";
	}
	
	@GetMapping("/public/faq")
	public String qa(Model model) {
		/*
		List<Qa> qalist = new ArrayList<>();

		
		for (int i = 0; i < 7; i++) {
			Qa qa = new Qa();
			qa.setPostId(0);
			qa.setTitle("환불언제됌");
			qa.setContent("내일이요");
			qalist.add(qa);
		}
		
		
		model.addAttribute("qalist", qalist);
		
		*/
		return "/public/faq";
	}
	
	@GetMapping("/public/Jproduct")
	public String JproductPage(Model model) {
		/*
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
		*/
	    return "/public/Jproduct";
	}
	
	
	//------------------------------------------------------------
	
	
	@GetMapping("/protected/mypage")
	public String mypage(Model model) {
		/*
		ProductModel product = new ProductModel();
		product.setImg("../../resources/img/{6E8F3DA7-4F8C-4BDF-85F6-962AF83FF710}.png");
		
		ProductModel product2 = new ProductModel();
		product2.setImg("../../resources/img/{5712D152-214F-4503-BA02-79971EB7682C}.png");
		
		
		List<ProductModel> plist = new ArrayList<>();
		plist.add(product);
		plist.add(product2);
		
		
		model.addAttribute("plist", plist);
		
		*/
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
	
	@GetMapping("/protected/order")
	public String order() {
		return "/protected/order";
	}
	@GetMapping("/protected/cs")
	public String product() {
		return "/protected/cs";
	}
	
	
}
