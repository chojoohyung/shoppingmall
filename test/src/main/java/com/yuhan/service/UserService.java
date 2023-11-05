package com.yuhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yuhan.entity.Role;
import com.yuhan.entity.User;
import com.yuhan.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
	
	public User save(User user) {
		String encodeedpassword = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(encodeedpassword);
		user.setEnabled(true);
		
		Role role = new Role();
		role.setId(1L);
		user.getRoles().add(role);
		
		return userRepository.save(user);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> findByemail(String email) {
		return userRepository.findByemail(email);
	}
	
	public Long updateUser(User user) {
		User myuser = userRepository.findByUsername(user.getUsername());
		
		String encodeedpassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodeedpassword);
		
		myuser.updateUser(user);
		
		
		
		userRepository.save(myuser);
		return myuser.getId();
	}
}
