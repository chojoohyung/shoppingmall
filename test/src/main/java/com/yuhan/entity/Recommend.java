 package com.yuhan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity	
@Getter @Setter	
@Table(name="recommend")
public class Recommend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public int category_TOP;
	public int category_BOTTOM;
	public int category_T_SHIRT;
	public int category_SHIRT;
	public int category_OUTER;
	public int category_SHOES;
	public int category_ACC;
	
	private int color_BLACK;
	private int color_WHITE;
	private int color_DEFAULT;
	
	private int size_S;
	private int size_M;
	private int size_L;
	private int size_260;
	private int size_265;
	private int size_270;
	private int size_275;
	private int size_280;
	private int size_285;
	
	public static Recommend createRecommend(User user) {
		Recommend recommend = new Recommend();
		recommend.setUser(user);
		return recommend;
	}
	
	
}
