package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class ACC implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setCategory_ACC(recommend.getCategory_ACC()+RecommendViewOrBuy);
		return recommend;
	}
}
