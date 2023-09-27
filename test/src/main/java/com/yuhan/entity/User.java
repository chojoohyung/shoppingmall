package com.yuhan.entity;

import java.util.ArrayList;
import java.util.List;

import com.yuhan.constant.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity	
@Data	
@Table(name="user")
public class User {
	@Id
	@Column(name="no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int no;
	
	@Column(unique = true)
	private String username;
	
	private String name;
	
	private String password;
	
	private Boolean enabled;
	
	private String phone;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@ManyToMany
	@JoinTable(
	  name = "user_role", 
	  joinColumns = @JoinColumn(name = "no"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();
	
	
	
}
