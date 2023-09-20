package com.yuhan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
	
//@Entity
@Data
/*	
 * QA 테이블
 * postId, title, content, + userid
 * 
 * */
public class Qa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
    private String title;
    private String content;

}
