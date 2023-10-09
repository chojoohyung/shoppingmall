package com.yuhan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yuhan.dto.ProductDto;
import com.yuhan.service.ProductService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	/*
	 * Admin용 상품등록 폼
	 */
	@GetMapping("/admin/product/new")
	public String ProductForm(Model model) {
		model.addAttribute("productDto", new ProductDto());
		return "/admin/ProductForm";
	}
	
	/*
	 * Admin용 상품등록 뷰
	 */
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
	
	/*
	 * Admin용 상품수정 폼
	 */
	@GetMapping("/admin/product/{id}")
	public String ProductDtl(@PathVariable("id") Long id, Model model) {
		try {
			ProductDto productDto = productService.getProductDtl(id);
			model.addAttribute("productDto", productDto);
		}catch(EntityNotFoundException e) {
			model.addAttribute("errorMessage", "존재하지 않는 상품입니다");
			model.addAttribute("productDto", new ProductDto());
			return "/admin/ProductForm";
		}

		return "/admin/ProductForm";
	}
	
	/*
	 * Admin용 상품수정 뷰
	 */
	@PostMapping("/admin/product/{id}")
	public String productUpdate(@Valid ProductDto productDto, BindingResult bindingResult, 
									@RequestParam("productImgFile") List<MultipartFile> productImgFileList, Model model) {
		if(bindingResult.hasErrors()) {
			return "/admin/ProductForm";
		}
		if(productImgFileList.get(0).isEmpty() && productDto.getId() == null) {
			model.addAttribute("errorMessage", "메인 이미지는 필수 입력값 입니다");
			return "/admin/ProductForm";
		}
		try {
			productService.updateProduct(productDto, productImgFileList);
		}catch(Exception e){
			model.addAttribute("errorMessage", "상품 수정 중 오류가 발생했습니다");
			return "/admin/ProductForm";
		}
		return "redirect:/";
	}
	
	/*
	 * 상품정보 리스트
	 */
	@GetMapping("/public/productList/{page}")
	public String productList(Model model, @PathVariable("page") Optional<Integer> page) {
		Pageable paging = PageRequest.of(page.isPresent() ? page.get() : 0 , 8);
		
		List<ProductDto> productDto = productService.test(paging);
		
		model.addAttribute("productPagingDto", productDto);
		return "/public/productList";
	}
	
	/*
	 * 상품상세정보
	 */
	@GetMapping("/public/product/{id}")
	public String productList(Model model, @PathVariable("id") Long id) {
		ProductDto productDto = productService.getProductDtl(id);
		model.addAttribute("productDto", productDto);
		return "/public/product";
	}
	
}
