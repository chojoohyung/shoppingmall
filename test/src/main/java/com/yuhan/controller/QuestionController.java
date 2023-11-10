package com.yuhan.controller;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

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
		return "redirect:/";
	}
	@GetMapping("/public/questionList")
	public String questionListGet(Model model) {
		List<Question> questionList = questionService.findAll();
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


