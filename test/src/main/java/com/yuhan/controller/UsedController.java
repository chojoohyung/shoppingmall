package com.yuhan.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yuhan.dto.ProductDto;
import com.yuhan.dto.UsedFormDto;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;
import com.yuhan.entity.Used;
import com.yuhan.entity.User;
import com.yuhan.service.OrderProductService;
import com.yuhan.service.ProductService;
import com.yuhan.service.UsedService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UsedController {
	
	private final UsedService usedService;
	
	/*
	 * 중고상품 리스트
	 */
	@GetMapping("/public/usedList")
	public String JproductPage(Model model) {
		List<Used> usedList = usedService.findAll();
		model.addAttribute("usedList", usedList);
	    return "/public/usedList";
	}
	
	/*
	 * 중고상품 상세정보
	 */
	@GetMapping("/public/used/{id}")
	public String productList(Model model, @PathVariable("id") Long id) {
		Used used;
		try {
			used = usedService.getDtl(id);
			model.addAttribute("used", used);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/public/used";
	}
	

	/*
	 * 중고상품 등록 폼
	 */
	@GetMapping("/protected/usedForm")
	public String JproductForm(Model model, Principal principal) {
		
		try {
			UsedFormDto usedFormDto = usedService.getProductDtl(principal.getName());
			model.addAttribute("usedFormDto", usedFormDto);
		}catch(EntityNotFoundException e) {
			List<Used> usedList = usedService.findAll();
			model.addAttribute("errorMessage", "구매한 상품이 없습니다");
			model.addAttribute("usedList", usedList);
			return "/public/usedList";
		}
		return "/protected/usedForm";
	}
	
	/*
	 * 중고상품 등록 뷰
	 */
	@PostMapping("/protected/usedForm")
	public String JproductFormPost(@Valid UsedFormDto usedFormDto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			List<Used> usedList = usedService.findAll();
			model.addAttribute("errorMessage", "필드 오류");
			model.addAttribute("usedList", usedList);
			return "/public/usedList";
		}
		try {
			usedService.save(usedFormDto);
			
		}catch(Exception e){
			System.out.println("used X");
			List<Used> usedList = usedService.findAll();
			model.addAttribute("usedList", usedList);
			return "/public/usedList";
		}
		
		return "redirect:/";
	}
	
	
}
