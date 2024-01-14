package com.easylearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class AddressMicroserviceWithEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressMicroserviceWithEurekaServerApplication.class, args);
	}

}
