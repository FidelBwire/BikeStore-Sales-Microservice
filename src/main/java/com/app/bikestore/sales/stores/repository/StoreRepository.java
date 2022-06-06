package com.app.bikestore.sales.stores.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.bikestore.sales.stores.entity.Store;

public interface StoreRepository extends PagingAndSortingRepository<Store, Long> {

}
