package com.yuhan.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuhan.entity.Recommend;
import com.yuhan.entity.User;
import com.yuhan.repository.RecommendRepository;
import com.yuhan.repository.UserRepository;
import com.yuhan.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private RecommendRepository recommendRepository;
	
	@GetMapping("public/login")
	public String login(User user) {
		return "public/login";
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
		
		Recommend recommend = Recommend.createRecommend(user);
		recommendRepository.save(recommend);
		
		return "/public/login";
	}
	
	@GetMapping("/public/search")
    public String showSearchForm() {
		
        return "/public/search"; // 검색 폼을 보여주는 HTML 파일 이름
    }
	
	@PostMapping("/public/search")
    public String Search(Model model, @RequestParam("email") String email) {
		
		List<User> userlist = userService.findByemail(email);
		model.addAttribute("userlist", userlist);
		
        return "/public/idresult"; // 검색 폼을 보여주는 HTML 파일 이름
    }
	
	
	
	@GetMapping("/protected/userUpdateForm")
    public String userUpdateForm(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user", user);
        return "/protected/userUpdateForm";
    }
	
	@PostMapping("/protected/userUpdateForm")
	public String userUpdate(User user, @RequestParam("addr2") String addr2, @RequestParam("addr3") String addr3) {
		user.setAddr(addr2+' '+addr3);
		userService.updateUser(user);
		return "redirect:/protected/mypage";
	}
	
	@GetMapping("/public/register/check_id")
	public @ResponseBody ResponseEntity checkId(@RequestParam("ID") String ID) {
		User user = userService.findByUsername(ID);
		if(user == null)
			return new ResponseEntity<Boolean>(true ,HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(false ,HttpStatus.OK);
	}
	
	@DeleteMapping("/protected/userUpdateForm/deleteUser")
	public @ResponseBody ResponseEntity deleteId(Principal principal) {
		User user = userService.findByUsername(principal.getName());
		if(user == null)
			return new ResponseEntity<Boolean>(false ,HttpStatus.OK);
		else {
			user.setEnabled(false);
			userRepository.save(user);
			return new ResponseEntity<Boolean>(true ,HttpStatus.OK);
		}
	}

}
