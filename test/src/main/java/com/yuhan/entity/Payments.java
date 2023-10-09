package com.yuhan.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity	
@Getter @Setter
@Table(name="payments")
/*
 * Product 테이블에 대응하는 클래스
 * 
 */
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date date;
	
	private int amount;
	
	private String status;
	
	private String method;
	
}
