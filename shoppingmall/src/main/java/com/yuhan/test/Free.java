package com.yuhan.test;

import com.yuhan.entity.Recommend;

public class Free implements RecommendInterface{

	@Override
	public Recommend update(Recommend recommend, int RecommendViewOrBuy) {
		recommend.setSize_Free(recommend.getSize_Free()+RecommendViewOrBuy);
		return recommend;
	}
}
