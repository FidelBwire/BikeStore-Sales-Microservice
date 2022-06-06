package com.app.bikestore.sales.orders.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.bikestore.sales.order_items.entity.OrderItem;
import com.app.bikestore.sales.order_items.service.OrderItemService;
import com.app.bikestore.sales.orders.entity.Order;
import com.app.bikestore.sales.orders.repository.OrderRepository;
import com.app.bikestore.sales.orders.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Override
	public Page<Order> getOrders(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Order> ordersPage = orderRepository.findAll(pageRequest);
		
		List<Order> ordersList = new ArrayList<>();
		ordersPage.forEach(order -> ordersList.add(order));
		
		return new PageImpl<Order>(ordersList, pageRequest, orderRepository.count());
	}

	@Override
	public List<OrderItem> getOrderItems(Long orderId) {
		return orderItemService.getOrderItems(orderId);
	}
}
