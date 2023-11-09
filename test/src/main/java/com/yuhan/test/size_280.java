package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class size_280 implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_280(recommend.getSize_280()+RecommendViewOrBuy);
		return recommend;
	}
}
