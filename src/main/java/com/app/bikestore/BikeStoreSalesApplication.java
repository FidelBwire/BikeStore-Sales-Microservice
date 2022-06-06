package com.app.bikestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BikeStoreSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeStoreSalesApplication.class, args);
	}

}
