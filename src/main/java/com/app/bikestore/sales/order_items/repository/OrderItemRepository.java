package com.app.bikestore.sales.order_items.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.bikestore.sales.order_items.entity.OrderItem;

public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Long> {
	List<OrderItem> findByOrderId(Long orderId);
	
	@Query(nativeQuery = true, 
			value = "SELECT `product_id`, SUM(`quantity`) FROM `order_items` GROUP BY `product_id` ORDER BY SUM(`quantity`) DESC")
	Map<Integer, Integer> getBestSellingProducts(int numberOfProducts);

	@Query(nativeQuery = true,
			value = "SELECT `id`,`list_price` FROM `order_items` LIMIT 5")
	Map<Integer, Integer> trySql();
}
