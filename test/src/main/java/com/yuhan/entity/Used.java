package com.yuhan.entity;

import java.time.LocalDateTime;

import com.yuhan.dto.UsedFormDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity	
@Getter @Setter	
@Table(name="used")
/*
 * Product 테이블에 대응하는 클래스
 * 
 */
public class Used {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private int price;
	
	private String content;
	
	//private LocalDateTime createDate; 
	
	
	@ManyToOne
	@JoinColumn(name = "orderProduct_id")
	private OrderProduct orderProduct;
	
	public void updateUsed(UsedFormDto usedFormDto, OrderProduct orderProduct) {
		this.title = usedFormDto.getTitle();
		this.price = usedFormDto.getPrice();
		this.content = usedFormDto.getContent();
		this.orderProduct = orderProduct;
		
	}
	
}
