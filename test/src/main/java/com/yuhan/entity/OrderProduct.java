package com.yuhan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity	
@Getter @Setter
public class OrderProduct {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	
	//주문상품 가격
	private int orderPrice;
	
	//주문상품 수량
	private int count;
	
	public static OrderProduct createOrderProduct(Product product, int count) {
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setProduct(product);
		orderProduct.setOrderPrice(product.getPrice());
		orderProduct.setCount(count);
		product.removeStock(count);
		return orderProduct;
	}
	
	public int getTotalPrice() {
		return orderPrice*count;
	}
	
	
	
	
	
}
