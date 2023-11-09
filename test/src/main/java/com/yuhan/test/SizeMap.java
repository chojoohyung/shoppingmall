package com.yuhan.test;

import java.util.HashMap;
import java.util.Map;

public class SizeMap {
	private Map<String, RecommendInterface> SizeCount;

    public SizeMap() {
        SizeCount = new HashMap<>();
        SizeCount.put("S", new S());
        SizeCount.put("M", new M());
        SizeCount.put("L", new L());
        SizeCount.put("260", new size_260());
        SizeCount.put("265", new size_265());
        SizeCount.put("270", new size_270());
        SizeCount.put("275", new size_275());
        SizeCount.put("280", new size_280());
        SizeCount.put("285", new size_285());
        SizeCount.put("기타", new size_Default());
        
    }


    public RecommendInterface getSizeUpdater(String size) {
        return SizeCount.get(size);
    }
}
