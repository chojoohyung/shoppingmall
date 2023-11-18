package com.yuhan.controller;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yuhan.entity.Question;
import com.yuhan.repository.UserRepository;
import com.yuhan.service.QuestionService;
import com.yuhan.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QuestionController {
	private final QuestionService questionService;
	private final UserRepository userRepository;
	
	@GetMapping("/protected/questionForm")
	public String questionGet(Model model ) {
		model.addAttribute("question",new Question());
		
		return "/protected/questionForm";
	}
	
	@PostMapping("/protected/questionForm")
	public String questionPost(Question question , Principal principal) {
		question.setUser(userRepository.findByUsername(principal.getName()));
		question.setQuestionDate(LocalDateTime.now());
		questionService.save(question);
		return "redirect:/public/questionList";
	}
	
	@GetMapping(value =  {"/public/questionList", "/public/questionList/{page}"})
	public String questionListGet(Model model, @PathVariable("page") Optional<Integer> page) {
		int pageSize = 10; // 페이지당 항목 수
	    int defaultPage = 0; // 기본 페이지 번호

	    if (page.isPresent()) {
	        if (page.get() < 0) {
	            // 페이지 번호가 0 미만인 경우 기본 페이지 번호로 설정
	            page = Optional.of(defaultPage);
	        }
	    } else {
	        page = Optional.of(defaultPage);
	    }

	    Pageable pageable = PageRequest.of(page.get(), pageSize, Sort.by(Sort.Direction.DESC, "id"));
		
		Page<Question> questionList = questionService.findAllpage(pageable);
		
		int totalPages = questionList.getTotalPages() - 1; // 전체 페이지 수
		
		
		model.addAttribute("totalPages", totalPages);
	    model.addAttribute("page", page.orElse(defaultPage)); // 현재 페이지 번호
		model.addAttribute("questionList",questionList);
		return "/public/questionList";
	}
	
	@GetMapping("/protected/question/{id}")
	public String question(@PathVariable("id") Long id, Model model) {
		
		Question question = questionService.findById(id);
		model.addAttribute("question",question);
		return "/protected/question";
	}
	
	
}


