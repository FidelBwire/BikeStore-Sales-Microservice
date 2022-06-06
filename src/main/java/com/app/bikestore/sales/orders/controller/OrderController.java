package com.app.bikestore.sales.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bikestore.sales.order_items.entity.OrderItem;
import com.app.bikestore.sales.orders.entity.Order;
import com.app.bikestore.sales.orders.service.OrderService;

@RestController
@RequestMapping("/sales/orders")
@CrossOrigin(origins = "http://localhost:4200/")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<Page<Order>> getOrders(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Page<Order> orders = orderService.getOrders(page, size);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	@GetMapping("/{orderId}/items")
	public ResponseEntity<List<OrderItem>> getOrderItems(
			@PathVariable(name = "orderId", required = true) Long orderId) {
		List<OrderItem> orderItems = orderService.getOrderItems(orderId);
		return new ResponseEntity<>(orderItems, HttpStatus.OK);
	}

}
