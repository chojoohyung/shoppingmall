package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class size_260 implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_260(recommend.getSize_260()+RecommendViewOrBuy);
		return recommend;
	}
}
