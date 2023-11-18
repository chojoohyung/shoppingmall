package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class size_Default implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_default(recommend.getSize_default()+RecommendViewOrBuy);
		return recommend;
	}
}
