package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class T_SHIRTS implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setCategory_T_SHIRT(recommend.getCategory_T_SHIRT()+RecommendViewOrBuy);
		return recommend;
	}
}
