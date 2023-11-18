package com.yuhan.test;

import java.util.HashMap;
import java.util.Map;

public class ColorMap {
	private Map<String, RecommendInterface> colorCount;

    public ColorMap() {
        colorCount = new HashMap<>();
        colorCount.put("BLACK", new BLACK());
        colorCount.put("WHITE", new WHITE());
        colorCount.put("기타", new color_Default());
    }
        

    public RecommendInterface getColorUpdater(String color) {
        return colorCount.get(color);
    }
}
