package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class BOTTOM implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setCategory_BOTTOM(recommend.getCategory_BOTTOM()+RecommendViewOrBuy);
		return recommend;
	}
}
