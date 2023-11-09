package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class WHITE implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setColor_WHITE(recommend.getColor_WHITE()+RecommendViewOrBuy);
		return recommend;
	}
}
