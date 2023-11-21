package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class size_275 implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_275(recommend.getSize_275()+RecommendViewOrBuy);
		return recommend;
	}
}
