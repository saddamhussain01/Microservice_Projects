package com.easylearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StrudentMicroserviceTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrudentMicroserviceTracingApplication.class, args);
	}

}
