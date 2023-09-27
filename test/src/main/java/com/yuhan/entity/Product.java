package com.yuhan.entity;

import com.yuhan.constant.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity	
@Data	
@Table(name="product")
/*
 * Product 테이블에 대응하는 클래스
 * 
 */
public class Product {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false, length = 50)
	private String name;
	
	@Column(nullable=false)
	private int price;
	
	@Column(nullable=false)
	private String color;
	
	@Column(nullable=false)
	private Size size;
	
	@Column(nullable=false)
	private int stock;
	
	private String category;
	
}
