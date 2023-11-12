package com.yuhan.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.yuhan.dto.UsedFormDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	private LocalDateTime createDate; 
	
	@OneToMany(mappedBy = "used")
	private List<UsedImg> usedImgList;
	
	@OneToMany(mappedBy = "used")
	private List<UsedComment> usedCommentList;
	
	@ManyToOne
	@JoinColumn(name = "orderProduct_id")
	private OrderProduct orderProduct;
	
	public void updateUsed(UsedFormDto usedFormDto) {
		this.title = usedFormDto.getTitle();
		this.price = usedFormDto.getPrice();
		this.content = usedFormDto.getContent();
		this.createDate = usedFormDto.getCreateDate();
		
	}
	
}
