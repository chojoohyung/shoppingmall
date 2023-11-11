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
import lombok.Getter;
import lombok.Setter;

@Entity	
@Getter @Setter	
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String name;
	
	private String password;
	
	private Boolean enabled;
	
	private String phone;
	
	private String email;
	
	private String addr;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
	@ManyToMany
	@JoinTable(
	  name = "user_role", 
	  joinColumns = @JoinColumn(name = "id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();
	
	public void updateUser(User user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.phone = user.getPhone();
		this.gender = user.getGender();
		this.addr = user.getAddr();
		this.name = user.getName();
		
	}
	
	
}
