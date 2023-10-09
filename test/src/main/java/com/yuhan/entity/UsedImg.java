package com.yuhan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="used_img")
/*
 * used 테이블에 대응하는 클래스
 * 
 */
public class UsedImg {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String oriImgName;
	
	private String imgName;
	
	private String imgUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="used_id")
	private Used used;
	
	public void updateProductImg(String oriImgName, String imgName, String imgUrl) {
		this.oriImgName = oriImgName;
		this.imgName = imgName;
		this.imgUrl = imgUrl;
		
	}
	
}
