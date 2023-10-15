package com.yuhan.entity;

import java.util.List;

import com.yuhan.constant.Size;
import com.yuhan.dto.ProductDto;
import com.yuhan.exception.OutOfStockException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity	
@Getter @Setter	
@Table(name="product")
/*
 * Product 테이블에 대응하는 클래스
 * 
 */
public class Product {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
	
	@OneToMany(mappedBy = "product")
	private List<ProductImg> productImgList;
	
	public void updateProduct(ProductDto productDto) {
		this.name = productDto.getName();
		this.price = productDto.getPrice();
		this.color = productDto.getColor();
		this.size = productDto.getSize();
		this.stock = productDto.getStock();
		this.category = productDto.getCategory();
	}
	
	public void removeStock(int stock) {
		int restStock = this.stock - stock;
		if(restStock<0) {
			throw new OutOfStockException("상품 재고가 부족합니다. 현재 재고 수량 : "+this.stock);
		}
		this.stock = restStock;
	}
	
}
