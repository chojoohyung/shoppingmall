package com.yuhan.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.yuhan.dto.OrderProductDto;
import com.yuhan.dto.UsedFormDto;
import com.yuhan.entity.Used;
import com.yuhan.entity.UsedComment;
import com.yuhan.entity.UsedImg;
import com.yuhan.service.OrderProductService;
import com.yuhan.service.UsedCommentService;
import com.yuhan.service.UsedImgService;
import com.yuhan.service.UsedReplyService;
import com.yuhan.service.UsedService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UsedController {
	
	private final UsedService usedService;
	private final OrderProductService orderProductService;
	private final UsedCommentService usedCommentService;
	private final UsedImgService usedImgService;
	private final UsedReplyService usedReplyService;
	
	
	
	
	/*
	 * 중고상품 등록 뷰
	 */
	@PostMapping("/protected/used/new")
	public String JproductFormPost(@Valid UsedFormDto usedFormDto, BindingResult bindingResult, Model model, Principal principal,
			@RequestParam("usedImgFile") List<MultipartFile> usedImgFilList, @RequestParam("selectedOrderProductId") Long selectedOrderProductId) {
		
		if(bindingResult.hasErrors()) {
			List<OrderProductDto> orderProductDtoList = orderProductService.findByName(principal.getName());
			model.addAttribute("errorMessage", "등록 오류");
			model.addAttribute("orderProductDtoList", orderProductDtoList);
			model.addAttribute("usedFormDto", new UsedFormDto());
			return "/protected/usedForm";
		}
		
		if(usedImgFilList.get(0).isEmpty() && usedFormDto.getId() == null) {
			List<OrderProductDto> orderProductDtoList = orderProductService.findByName(principal.getName());
			model.addAttribute("errorMessage", "이미지는 순서대로 등록해주십시요");
			model.addAttribute("orderProductDtoList", orderProductDtoList);
			model.addAttribute("usedFormDto", new UsedFormDto());
			return "/protected/usedForm";
		}
		
		try {
			usedFormDto.setOrderProduct(orderProductService.findById(selectedOrderProductId));
			usedService.save(usedFormDto, usedImgFilList);
			
		}catch(Exception e){
			List<OrderProductDto> orderProductDtoList = orderProductService.findByName(principal.getName());
			model.addAttribute("errorMessage", "글 등록중 오류가 발생했습니다.");
			model.addAttribute("orderProductDtoList", orderProductDtoList);
			model.addAttribute("usedFormDto", new UsedFormDto());
			return "/protected/usedForm";
		}
		
		return "redirect:/public/usedList";
	}
	
	/*
	 * 중고상품 등록 폼
	 */
	@GetMapping("/protected/used/new")
	public String JproductForm(Model model, Principal principal) {

		List<OrderProductDto> orderProductDtoList = orderProductService.findByName(principal.getName());
		
		model.addAttribute("orderProductDtoList", orderProductDtoList);
		model.addAttribute("usedFormDto", new UsedFormDto());
			
		return "/protected/usedForm";
	}
	
	/*
	 * 중고상품 리스트
	 */
	@GetMapping(value = {"/public/usedList/{page}", "/public/usedList"})
	public String JproductPage(Model model, @PathVariable("page") Optional<Integer> page, Principal principal) {
	    int pageSize = 8; // 페이지당 항목 수
	    int defaultPage = 0; // 기본 페이지 번호

	    if (page.isPresent()) {
	        if (page.get() < 0) {
	            // 페이지 번호가 0 미만인 경우 기본 페이지 번호로 설정
	            page = Optional.of(defaultPage);
	        }
	    } else {
	        page = Optional.of(defaultPage);
	    }

	    Pageable pageable = PageRequest.of(page.get(), pageSize);

	    Page<Used> usedPage = usedService.test(pageable);
	    List<Used> usedList = usedPage.getContent(); // 현재 페이지의 항목 목록
	    int totalPages = usedPage.getTotalPages() - 1; // 전체 페이지 수
	    
	    if(principal != null) {
	    	List<OrderProductDto> orderProductDtoList = orderProductService.findByName(principal.getName());
	    	if(orderProductDtoList.isEmpty()) {
	    		
	    	}else {
	    		model.addAttribute("orderProduct_Empty", "1");
	    	}
	    }
	    
	    model.addAttribute("usedList", usedList);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("page", page.orElse(defaultPage)); // 현재 페이지 번호
	    return "/public/usedList";
	}
	
	/*
	 * 내 중고상품 리스트
	 */
	@GetMapping(value = {"/protected/usedList/{page}", "/protected/usedList"})
	public String userProductPage(Model model, @PathVariable("page") Optional<Integer> page, Principal principal) {
	    int pageSize = 8; // 페이지당 항목 수
	    int defaultPage = 0; // 기본 페이지 번호

	    if (page.isPresent()) {
	        if (page.get() < 0) {
	            // 페이지 번호가 0 미만인 경우 기본 페이지 번호로 설정
	            page = Optional.of(defaultPage);
	        }
	    } else {
	        page = Optional.of(defaultPage);
	    }

	    Pageable pageable = PageRequest.of(page.get(), pageSize, Sort.by("createDate").descending());

	    Page<Used> usedPage = usedService.findByOrderProduct_Order_User_username(pageable, principal.getName());
	    List<Used> usedList = usedPage.getContent(); // 현재 페이지의 항목 목록
	    int totalPages = usedPage.getTotalPages() - 1; // 전체 페이지 수
	    
	    if(principal != null) {
	    	List<OrderProductDto> orderProductDtoList = orderProductService.findByName(principal.getName());
	    	if(orderProductDtoList.isEmpty()) {
	    		
	    	}else {
	    		model.addAttribute("orderProduct_Empty", "1");
	    	}
	    }
	    
	    model.addAttribute("usedList", usedList);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("page", page.orElse(defaultPage)); // 현재 페이지 번호
	    return "/public/usedList";
	}
	
	
	
	
	/*
	 * 중고상품 상세정보
	 */
	@GetMapping("/public/used/{id}")
	public String productList(Model model, @PathVariable("id") Long id, Principal principal) {
		Used used;
		try {
			used = usedService.getDtl(id);
			model.addAttribute("used", used);
			
			if (principal != null) {
	            model.addAttribute("username", principal.getName());
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/public/used";
	}
	
	/*
	 * 중고상품 상세정보 댓글입력
	 */
	
	@PostMapping("/public/used/{id}/comment")
	public @ResponseBody ResponseEntity saveComment(@PathVariable("id") Long id, @RequestParam("content") String content, @RequestParam("isPrivate") Boolean isPrivate, Principal principal) {		
		usedCommentService.save(id, content, isPrivate, principal.getName());
		return new ResponseEntity<String>("댓글작성", HttpStatus.OK);
	}
	
	/*
	 * 중고상품 상세정보 답글입력
	 */
	
	@PostMapping("/public/used/{id}/{replyId}")
	public @ResponseBody ResponseEntity saveReply(@PathVariable("id") Long id, @PathVariable("replyId") Long replyId,  @RequestParam("content") String content, @RequestParam("isPrivate") Boolean isPrivate, Principal principal) {		
		usedReplyService.save(id, content, isPrivate, principal.getName(), replyId);
		return new ResponseEntity<String>("댓글작성", HttpStatus.OK);
	}
	
	
	
	/*
	 * 중고 글 삭제 
	 */
	@DeleteMapping("/public/used/{id}")
	public @ResponseBody ResponseEntity productListDelete(@PathVariable("id") Long id, Principal principal)  {

		Used used;
		if(principal == null) {
			return new ResponseEntity<String>("유저정보가 없습니다", HttpStatus.BAD_REQUEST);
		}
		try {
			used = usedService.getDtl(id);
			List<UsedComment> usedCommentList = usedCommentService.findusedId(used.getId());
			List<UsedImg> usedImgList = usedImgService.findByUsed(used);	
			
			for (UsedComment usedComment : usedCommentList) {
				usedCommentService.delete(usedComment);
			}
			for (UsedImg usedImg : usedImgList) {
				usedImgService.delete(usedImg);
			}
			usedService.delete(used);
		} catch (Exception e) {
			return new ResponseEntity<String>("삭제오류", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Long>(1L, HttpStatus.OK);
	}

	
	
	
}
