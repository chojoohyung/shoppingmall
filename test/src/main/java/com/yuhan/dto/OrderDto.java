package com.yuhan.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDto {
	
	@NotNull(message = "상품아이디 입력")
	private Long productId;
	
	@Min(value = 1, message="최소 주문수량 1개")
	@Max(value = 999, message = "최대 주문수량 999개")
	private int count;
}
