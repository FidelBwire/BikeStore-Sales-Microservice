package com.app.bikestore.sales.stores.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.bikestore.sales.stores.entity.Store;
import com.app.bikestore.sales.stores.repository.StoreRepository;
import com.app.bikestore.sales.stores.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Page<Store> getStores(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Store> stores = storeRepository.findAll(pageRequest);
		
		List<Store> storesList = new ArrayList<>();
		stores.forEach(store -> storesList.add(store));
		
		return new PageImpl<Store>(storesList, pageRequest, storeRepository.count());
	}
}
