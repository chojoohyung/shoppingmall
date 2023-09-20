package com.yuhan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
	
//@Entity
@Data
/*
 * 상품 테이블
 * id, img, name, price, url
 * 
 * */
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String img;
	private String name;
	private int price;
	private String url;

}
