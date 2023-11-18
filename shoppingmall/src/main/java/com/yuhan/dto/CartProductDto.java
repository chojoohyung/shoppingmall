package com.yuhan.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartProductDto {

	@NotNull(message = "상품 아이디 필수 입력")
	private Long productId;
	
	@Min(value = 1, message = "최소 1개 이상")
	private int count;
}
