package com.app.bikestore.sales.stores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bikestore.sales.stores.entity.Store;
import com.app.bikestore.sales.stores.service.StoreService;

@RestController
@RequestMapping(value = "/sales/stores")
@CrossOrigin(origins = "http://localhost:4200")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping
	public ResponseEntity<Page<Store>> getStores(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Page<Store> stores = storeService.getStores(page, size);
		return new ResponseEntity<Page<Store>>(stores, HttpStatus.OK);
	}
}
