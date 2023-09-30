package com.yuhan.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yuhan.dto.ProductDto;
import com.yuhan.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("/admin/product/new")
	public String ProductForm(Model model) {
		model.addAttribute("productDto", new ProductDto());
		return "/admin/ProductForm";
	}
	
	@PostMapping(value = "/admin/product/new")
	public String productNew(@Valid ProductDto productDto, BindingResult bindingResult, Model model, 
			@RequestParam("productImgFile") List<MultipartFile> productImgFilList) {
		
		
		if(bindingResult.hasErrors()) {
			return "/admin/ProductForm";
		}
		
		if(productImgFilList.get(0).isEmpty() && productDto.getId() == null) {
			model.addAttribute("errorMessage", "메인 이미지는 필수 입력값 입니다");
			return "/admin/ProductForm";
		}
		
		try {
			productService.saveProduct(productDto, productImgFilList);
		}catch(Exception e){
			model.addAttribute("errorMessage", "상품 등록 중 오류가 발생했습니다");
			return "/admin/ProductForm";
		}
		return "redirect:/";
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
	
}
