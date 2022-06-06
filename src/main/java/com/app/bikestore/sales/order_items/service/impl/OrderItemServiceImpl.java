package com.app.bikestore.sales.order_items.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bikestore.exception.handlers.ResourceNotFoundException;
import com.app.bikestore.sales.order_items.entity.OrderItem;
import com.app.bikestore.sales.order_items.repository.OrderItemRepository;
import com.app.bikestore.sales.order_items.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public OrderItem getOrderItem(Long orderItemId) {
		OrderItem orderItem = orderItemRepository.findById(orderItemId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"No order item by id " + orderItemId));
		return orderItem;
	}

	@Override
	public List<OrderItem> getOrderItems(Long orderId) {
		List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderId);
		return orderItems;
	}

	@Override
	public Map<Integer, Integer> getBestSellingProducts(int numberOfProducts) {
		return orderItemRepository.getBestSellingProducts(numberOfProducts);
	}

}
