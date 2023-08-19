package com.yuhan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.log.Log;
import com.yuhan.model.Product;
import com.yuhan.model.User;
import com.yuhan.service.UserService;


@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	public String login(User user) {
		


		return "/account/login";
	}
	
	
	@GetMapping("/register")
	public String register() {
		return "/account/register";
	}
	
	
	@PostMapping("/register")
	public String register(User user) {
		userService.save(user);
		return "/account/login";
	}
	
	
		
}