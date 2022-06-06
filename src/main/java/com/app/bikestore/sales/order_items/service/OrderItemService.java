package com.app.bikestore.sales.order_items.service;

import java.util.List;
import java.util.Map;

import com.app.bikestore.sales.order_items.entity.OrderItem;

public interface OrderItemService {	
	List<OrderItem> getOrderItems(Long orderId);
	OrderItem getOrderItem(Long orderItemId);	
	Map<Integer, Integer> getBestSellingProducts(int numberOfProducts);
}
