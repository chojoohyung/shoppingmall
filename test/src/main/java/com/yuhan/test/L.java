package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class L implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_L(recommend.getSize_L()+RecommendViewOrBuy);
		return recommend;
	}
}
