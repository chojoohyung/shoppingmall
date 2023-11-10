package com.yuhan.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartRemoveDto {

	private Long cartProductId;
	
	private int stock;
	
	private List<CartRemoveDto> cartRemoveDtoList;
	
}	
