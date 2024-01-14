package com.easylearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerMicroserviceApplication.class, args);
	}

}
