package com.yuhan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity	
@Data	
@Table(name="used")
/*
 * Product 테이블에 대응하는 클래스
 * 
 */
public class Used {
	
	@Id
	@Column(name="used_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long no;
	
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	
	private String title;
	
	
	private int price;
	
	
	private String content;
	
	
}
