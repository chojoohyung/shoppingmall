package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class color_Default implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setColor_DEFAULT(recommend.getColor_DEFAULT()+RecommendViewOrBuy);
		return recommend;
	}
}
