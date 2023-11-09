package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class size_270 implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_270(recommend.getSize_270()+RecommendViewOrBuy);
		return recommend;
	}
}
