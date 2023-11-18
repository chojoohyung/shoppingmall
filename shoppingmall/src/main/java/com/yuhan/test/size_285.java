package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class size_285 implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_285(recommend.getSize_285()+RecommendViewOrBuy);
		return recommend;
	}
}
