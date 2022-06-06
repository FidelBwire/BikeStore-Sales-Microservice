package com.app.bikestore.sales.analytics.service;

import java.util.Map;

public interface OrderItemsAnalyticsService {

	Map<Integer, Integer> getBestSellingProducts(int numberOfProducts);

}
