package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class size_265 implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_265(recommend.getSize_265()+RecommendViewOrBuy);
		return recommend;
	}
}
