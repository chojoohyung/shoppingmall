package com.yuhan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yuhan.model.Role;
import com.yuhan.model.User;
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
}
