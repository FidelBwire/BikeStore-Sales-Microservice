package com.app.bikestore.sales.analytics.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bikestore.sales.analytics.repository.OrderItemsAnalyticsRepository;
import com.app.bikestore.sales.analytics.service.OrderItemsAnalyticsService;

@Service
public class OrderItemsAnalyticsServiceImpl implements OrderItemsAnalyticsService {
	
	@Autowired
	private OrderItemsAnalyticsRepository orderItemsAnalyticsRepository;

	@Override
	public Map<Integer, Integer> getBestSellingProducts(int numberOfProducts) {
		return orderItemsAnalyticsRepository.getBestSellingProducts(numberOfProducts);
	}

}
