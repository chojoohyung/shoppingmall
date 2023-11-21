package com.yuhan.dto;

import org.modelmapper.ModelMapper;

import com.yuhan.entity.ProductImg;
import com.yuhan.entity.UsedImg;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UsedImgDto {
	private Long id;

	private String oriImgName;
	
	private String imgName;
	
	private String imgUrl;
	
	
	private static ModelMapper modelMappler = new ModelMapper();
	
	public static UsedImgDto of(UsedImg usedImge) {
		return modelMappler.map(usedImge, UsedImgDto.class);
	}
	
	
}
