package com.yuhan.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuhan.entity.User;
import com.yuhan.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/public/login")
	public String login(User user) {
		return "/public/login";
	}
	
	@GetMapping("/public/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "/public/register";
	}
	
	@PostMapping("/public/register")
	public String register(User user, @RequestParam("addr2") String addr2, @RequestParam("addr3") String addr3) {
		user.setAddr(addr2+' '+addr3);
		userService.save(user);
		return "/public/login";
	}
	
	@GetMapping("/public/search")
    public String showSearchForm() {
        return "/public/search"; // 검색 폼을 보여주는 HTML 파일 이름
    }
	
	@GetMapping("/protected/userUpdateForm")
    public String userUpdateForm(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user", user);
        return "/protected/userUpdateForm";
    }
	
	@PostMapping("/protected/userUpdateForm")
	public String userUpdate(User user) {
		userService.updateUser(user);
		return "redirect:/";
	}
	

}
