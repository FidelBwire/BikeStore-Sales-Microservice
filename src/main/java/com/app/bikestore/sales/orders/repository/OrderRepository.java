package com.app.bikestore.sales.orders.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.bikestore.sales.orders.entity.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{

}
