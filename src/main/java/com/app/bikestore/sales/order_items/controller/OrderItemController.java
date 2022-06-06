package com.app.bikestore.sales.order_items.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bikestore.sales.order_items.entity.OrderItem;
import com.app.bikestore.sales.order_items.repository.OrderItemRepository;
import com.app.bikestore.sales.order_items.service.OrderItemService;

@RestController
@RequestMapping("/sales/orderItems")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService; 

	@GetMapping()
	public ResponseEntity<OrderItem> getOrderItem(
			@RequestParam(name = "orderItemId", required = true) Long orderItemId) {
		OrderItem orderItem = orderItemService.getOrderItem(orderItemId);
		return new ResponseEntity<OrderItem>(orderItem, HttpStatus.OK);
	}
	
//	@GetMapping()
//	public ResponseEntity<List<OrderItem>> getOrderItems(
//			@RequestParam(name = "orderId", required = true) Long orderId) {
//		List<OrderItem> orderItem = orderItemService.getOrderItems(orderId);
//		return new ResponseEntity<List<OrderItem>>(orderItem, HttpStatus.OK);
//	}
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@GetMapping("/try")
	public ResponseEntity<Map<Integer, Integer>> trySql() {
		Map<Integer, Integer> results = orderItemRepository.trySql();
		return new ResponseEntity<Map<Integer, Integer>>(results, HttpStatus.OK);
	}
	
	@GetMapping("/best-selling-products")
	public ResponseEntity<Map<Integer, Integer>> getBestSellingProducts(
			@RequestParam(name = "products", defaultValue = "10") int numberOfProducts) {
		Map<Integer, Integer> bestSellingProducts = new HashMap();
		bestSellingProducts = orderItemService.getBestSellingProducts(numberOfProducts); 
		return new ResponseEntity<Map<Integer,Integer>>(bestSellingProducts, HttpStatus.OK);
	}
	
}
