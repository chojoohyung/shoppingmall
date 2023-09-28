package com.yuhan.entity;

import com.yuhan.constant.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity	
@Data	
@Table(name="product_img")
/*
 * Product 테이블에 대응하는 클래스
 * 
 */
public class ProductImg {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String imgName;
	
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public void updateProductImg(String imgName, String imgUrl) {
		this.imgName = imgName;
		this.imgUrl = imgUrl;
		
	}
	
	
}