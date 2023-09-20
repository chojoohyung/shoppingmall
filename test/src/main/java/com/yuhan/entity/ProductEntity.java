package com.yuhan.entity;

import com.yuhan.constant.ProductSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class ProductEntity {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=50)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private ProductSellStatus productSellStatus;

}
