package com.yuhan.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
	



@Entity
@Data
/*
 * 유저 테이블
 * id, username, password, enabled
 * 
 * */
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private Boolean enabled;
	
	
	
	@ManyToMany
	@JoinTable(
	  name = "user_role", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();
	

}
