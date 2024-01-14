package com.easylearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressMicroserviceWithLoadBalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressMicroserviceWithLoadBalancerApplication.class, args);
	}

}