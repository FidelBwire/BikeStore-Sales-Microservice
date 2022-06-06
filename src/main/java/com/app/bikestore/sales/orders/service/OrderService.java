package com.app.bikestore.sales.orders.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.bikestore.sales.order_items.entity.OrderItem;
import com.app.bikestore.sales.orders.entity.Order;

public interface OrderService {
	Page<Order> getOrders(int page, int size);
	List<OrderItem> getOrderItems(Long orderId);
}
