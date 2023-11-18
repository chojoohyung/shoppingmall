package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class BLACK implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setColor_BLACK(recommend.getColor_BLACK()+RecommendViewOrBuy);
		return recommend;
	}
}
