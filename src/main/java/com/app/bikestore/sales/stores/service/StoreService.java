package com.app.bikestore.sales.stores.service;

import org.springframework.data.domain.Page;

import com.app.bikestore.sales.stores.entity.Store;

public interface StoreService {

	Page<Store> getStores(int page, int size);
	
}
