package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class S implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_S(recommend.getSize_S()+RecommendViewOrBuy);
		return recommend;
	}
}
