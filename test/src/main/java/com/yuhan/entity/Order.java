package com.yuhan.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity	
@Data	
@Table(name="orders")
public class Order {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	//주문일
	private LocalDateTime orderDate; 
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderProduct> orderProducts = new ArrayList<>();
	
	public void addOrderProduct(OrderProduct orderProduct) {
		orderProducts.add(orderProduct);
		orderProduct.setOrder(this);
	}
	
	public static Order createOrder(User user, List<OrderProduct> orderProductList) {
		Order order = new Order();
		order.setUser(user);
		for (OrderProduct orderProduct : orderProductList) {
			order.addOrderProduct(orderProduct);
		}
		order.setOrderDate(LocalDateTime.now());
		return order;
	}
	
	public int getTotalPrice() {
		int totalPrice = 0;
		for (OrderProduct orderProduct : orderProducts) {
			totalPrice += orderProduct.getTotalPrice();
		}
		return totalPrice;
	}
	
	
	
	
	
}
