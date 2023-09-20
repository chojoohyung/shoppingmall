package com.yuhan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity	
@Data	
@Table(name="board")
public class BoardEntity {
	@Id
	@Column(name="idx")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length=255, name="title")
	private String title;
	
	@Column(length=65535, name="content")
	private String content;
}
