package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class M implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_M(recommend.getSize_M()+RecommendViewOrBuy);
		return recommend;
	}
}
