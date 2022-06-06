package com.app.bikestore.sales.analytics.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.bikestore.sales.order_items.entity.OrderItem;

public interface OrderItemsAnalyticsRepository extends PagingAndSortingRepository<OrderItem, Long> {

	@Query(nativeQuery = true, 
			value = "SELECT `product_id`, SUM(`quantity`) FROM `order_items` GROUP BY `product_id` ORDER BY SUM(`quantity`) DESC")
	Map<Integer, Integer> getBestSellingProducts(int numberOfProducts);

}
