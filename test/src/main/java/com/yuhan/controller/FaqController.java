package com.yuhan.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yuhan.entity.Faq;
import com.yuhan.repository.UserRepository;
import com.yuhan.service.FaqService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FaqController {
	
	private final FaqService faqService;
	private final UserRepository userRepository;


	@GetMapping("/public/faqForm")
	public String faqForm(Model model ) {
		model.addAttribute("faq",new Faq());
		
		return "/public/faqForm";
	}
	
	@PostMapping("/public/faqForm")
	public String faqForm(Faq faq , Principal principal) {
		faq.setUser(userRepository.findByUsername(principal.getName()));
		faqService.save(faq);
		return "redirect:/public/faqList";
	}
	@GetMapping("/public/faqList")
	public String faqListGet(Model model) {
		List<Faq> faqList = faqService.findAll();
		model.addAttribute("faqList",faqList);
		return "/public/faqList";
	}

	
}
