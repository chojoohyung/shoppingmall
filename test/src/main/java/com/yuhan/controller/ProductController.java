package com.yuhan.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yuhan.dto.ProductDto;
import com.yuhan.entity.Product;
import com.yuhan.entity.Used;
import com.yuhan.entity.User;
import com.yuhan.service.ProductService;
import com.yuhan.service.RecommendService;
import com.yuhan.service.UsedService;
import com.yuhan.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	private final UserService userService;
	private final RecommendService recommendService;
	private final UsedService usedService;
	
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
	 * Main 상품게시글
	 */
	@GetMapping("/")
	public String main(Model model, Optional<Integer> page) {
		Pageable paging = PageRequest.of(page.isPresent() ? page.get() : 0 , 100);
		
		List<ProductDto> productDto = productService.test(paging);
		
		model.addAttribute("productPagingDto", productDto);
		return "/main";
	}
	
	/*
	 * BEST50 상품게시글
	 */
	@GetMapping("/public/productList")
	public String productList(Model model, @RequestParam(name = "category", required = false) String category, Optional<Integer> page) {
		Pageable paging = PageRequest.of(page.isPresent() ? page.get() : 0 , 50);
		
		List<ProductDto> productDto;
		
		/*
		 * 카테고리
		 */
		if (category != null) {
	    	productDto = productService.findcategory(paging, category);
	    } else {
	        // 카테고리가 전달되지 않은 경우 기본적으로 전체 상품 목록을 가져옵니다.
	        productDto = productService.test(paging);
	    }
		
		model.addAttribute("productPagingDto", productDto);
		return "/public/productList";
	}
	
	/*
	 * 상품상세정보
	 */
	@GetMapping("/public/product/{id}")
	public String productList(Model model, @PathVariable("id") Long id, Principal principal) {
		
		if(principal != null) {
			User user = userService.findByUsername(principal.getName());
			recommendService.updateRecommend(id, principal.getName(), 1);
			model.addAttribute("user", user);
		}
		
		ProductDto productDto = productService.getProductDtl(id);
		List<Used> PIDUsedList = usedService.getPIDUsedList(id);
		
		model.addAttribute("productDto", productDto);
		model.addAttribute("PIDUsedList", PIDUsedList);
		
		return "/public/product";
	}
	
	@DeleteMapping("/public/product/{id}")
	public @ResponseBody ResponseEntity productDelete(@PathVariable("id") Long id) {
		productService.delete(id);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
}
