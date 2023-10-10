package com.yuhan.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;
import com.yuhan.entity.Used;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsedFormDto {
	
	private Long id;
	private String title;
	private int price;
	private String content;
	private LocalDateTime createDate;
	
	private Long selectOrderProductId;
	private List<OrderProductDto> orderProductDtoList = new ArrayList<>();
	
	/*
	 * ModelMapper : Entity와 Dto간의 같은필드 값 매핑
	 */
	private static ModelMapper modelMapper = new ModelMapper();
	
	/*
	 * Entity <- Dto
	 * Entity entity = Dto.createEntity();
	 */
	public Used createUsed() {
		
		return modelMapper.map(this, Used.class);
	}
	
	/*
	 * Dto <- Entity
	 * Dto dto = Dto.of(entity)
	 */
	public static UsedFormDto of(Used used) {
		return modelMapper.map(used, UsedFormDto.class);
	}
	
}
