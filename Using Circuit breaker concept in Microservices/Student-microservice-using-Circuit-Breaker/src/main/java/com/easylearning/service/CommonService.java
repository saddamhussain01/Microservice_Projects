package com.easylearning.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easylearning.feignClients.AddressFeignClient;
import com.easylearning.response.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	Logger logger = LoggerFactory.getLogger(CommonService.class);
	

	@Autowired
	AddressFeignClient addressFeignClient;
	
	
	long count =1;
	
	
	@CircuitBreaker(name = "addressMicroservice",fallbackMethod = "fallBackGetAddressById")
	public AddressResponse getAddressById (long addressId) {
		
		logger.info("Count =  " + count);
		count++;
		
		AddressResponse addressResponse = 
				addressFeignClient.getById(addressId);
		
		return addressResponse;
	}
	
	
	
	public AddressResponse fallBackGetAddressById (long addressId, Throwable th) {     //Throwable is optional
		
		logger.error("Error = " + th);
		return new AddressResponse();
	}

}
