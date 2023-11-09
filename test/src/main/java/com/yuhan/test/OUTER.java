package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class OUTER implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setCategory_OUTER(recommend.getCategory_OUTER()+RecommendViewOrBuy);
		return recommend;
	}
}
