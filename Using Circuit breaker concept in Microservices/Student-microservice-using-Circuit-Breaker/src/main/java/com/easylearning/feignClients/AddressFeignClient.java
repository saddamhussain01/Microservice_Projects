package com.easylearning.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.easylearning.response.AddressResponse;


@FeignClient(value = "api-gateway")
public interface AddressFeignClient {

	@GetMapping("address-microservice/api/address/getById/{id}")
	public AddressResponse getById(@PathVariable long id);
	
}

