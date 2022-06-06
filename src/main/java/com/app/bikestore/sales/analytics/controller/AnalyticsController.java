package com.app.bikestore.sales.analytics.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bikestore.sales.analytics.service.OrderItemsAnalyticsService;

@RestController
@RequestMapping("/sales/analytics")
@CrossOrigin(origins = "http://localhost:4200")
public class AnalyticsController {
	
	@Autowired
	private OrderItemsAnalyticsService orderItemsAnalyticsService;
	
	@GetMapping("/best-selling-products")
	public ResponseEntity<Map<Integer, Integer>> getBestSellingProducts(
			@RequestParam(name = "products", defaultValue = "10") int numberOfProducts) {
		Map<Integer, Integer> bestSellingProducts = new HashMap();
		bestSellingProducts = orderItemsAnalyticsService.getBestSellingProducts(numberOfProducts); 
		return new ResponseEntity<Map<Integer,Integer>>(bestSellingProducts, HttpStatus.OK);
	}

}
