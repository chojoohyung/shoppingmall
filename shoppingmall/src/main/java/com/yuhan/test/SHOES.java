package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class SHOES implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setCategory_SHOES(recommend.getCategory_SHOES()+RecommendViewOrBuy);
		return recommend;
	}
}
