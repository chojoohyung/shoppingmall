package com.yuhan.test;

import java.util.HashMap;
import java.util.Map;

public class CategoryMap {
	private Map<String, RecommendInterface> categoryCount;

    public CategoryMap() {
        categoryCount = new HashMap<>();
        categoryCount.put("TOP", new TOP());
        categoryCount.put("BOTTOM", new BOTTOM());
        categoryCount.put("T-SHIRTS", new T_SHIRTS());
        categoryCount.put("SHIRTS", new SHIRTS());
        categoryCount.put("OUTER", new OUTER());
        categoryCount.put("SHOES", new SHOES());
        categoryCount.put("ACC", new ACC());
    }

    public RecommendInterface getCategoryUpdater(String category) {
        return categoryCount.get(category);
    }
}
