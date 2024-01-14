package com.easylearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easylearning.entity.Student;
import com.easylearning.feignClients.AddressFeignClient;
import com.easylearning.repository.StudentRepository;
import com.easylearning.request.CreateStudentRequest;
import com.easylearning.response.AddressResponse;
import com.easylearning.response.StudentResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	@Autowired
	AddressFeignClient addressFeignClient;
	
	@Autowired
	CommonService commonService;
	

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);
		
		StudentResponse studentResponse = new StudentResponse(student);
		
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));

		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		
		return studentResponse;
	}
	
	
	/*
	 * @CircuitBreaker(name = "addressMicroservice",fallbackMethod =
	 * "fallBackGetAddressById") public AddressResponse getAddressById (long
	 * addressId) { AddressResponse addressResponse =
	 * addressFeignClient.getById(addressId);
	 * 
	 * return addressResponse; }
	 * 
	 * 
	 * 
	 * public AddressResponse fallBackGetAddressById (long addressId, Throwable th)
	 * { //Throwable is optional return new AddressResponse(); }
	 */
	
}
	
