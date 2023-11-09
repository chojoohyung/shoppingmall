package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class SHIRTS implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setCategory_SHIRT(recommend.getCategory_SHIRT()+RecommendViewOrBuy);
		return recommend;
	}
}
