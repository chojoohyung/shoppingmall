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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yuhan.dto.OrderProductDto;
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
	private final OrderProductService orderProductService;
	
	/*
	 * 중고상품 등록 폼
	 */
	@GetMapping("/protected/used/new")
	public String JproductForm(Model model, Principal principal) {

		List<OrderProductDto> orderProductDtoList = orderProductService.findByName(principal.getName());
		
		if(orderProductDtoList.isEmpty()) {
			List<Used> usedList = usedService.findAll();
			model.addAttribute("errorMessage", "구매한 상품이 없습니다");
			model.addAttribute("usedList", usedList);
			return "/public/usedList";
		}
		
		
		model.addAttribute("orderProductDtoList", orderProductDtoList);
		model.addAttribute("usedFormDto", new UsedFormDto());
			
		return "/protected/usedForm";
	}
	
	/*
	 * 중고상품 등록 뷰
	 */
	@PostMapping("/protected/used/new")
	public String JproductFormPost(@Valid UsedFormDto usedFormDto, BindingResult bindingResult, Model model, 
			@RequestParam("usedImgFile") List<MultipartFile> usedImgFilList, @RequestParam("selectedOrderProductId") Long selectedOrderProductId) {
		
		if(bindingResult.hasErrors()) {
			return "/protected/usedForm";
		}
		
		if(usedImgFilList.get(0).isEmpty() && usedFormDto.getId() == null) {
			model.addAttribute("errorMessage", "이미지는 최소 1개이상 등록해주십시요");
			return "/protected/usedForm";
		}
		
		try {
			usedFormDto.setOrderProduct(orderProductService.findById(selectedOrderProductId));
			usedService.save(usedFormDto, usedImgFilList);
			
		}catch(Exception e){
			model.addAttribute("errorMessage", "글 등록중 오류가 발생했습니다.");
			return "/protected/usedForm";
		}
		
		return "redirect:/";
	}
	
	/*
	 * 중고상품 수정 폼
	 */
	@GetMapping("/protected/used/{id}")
	public String ProductDtl(@PathVariable("id") Long id, Model model) {
		try {
			/* 미구현
			UsedFormDto usedFormDto = usedService.getProductDtl(id);
			model.addAttribute("productDto", productDto);
			*/
		}catch(EntityNotFoundException e) {
			model.addAttribute("errorMessage", "존재하지 않는 상품입니다");
			model.addAttribute("usedFormDto", new UsedFormDto());
			return "/protected/usedForm";
		}

		return "/protected/usedForm";
	}
	
	
	
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
	

	
	
	
}
