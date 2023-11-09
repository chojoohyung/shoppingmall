package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class TOP implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setCategory_TOP(recommend.getCategory_TOP()+RecommendViewOrBuy);
		return recommend;
	}
}
