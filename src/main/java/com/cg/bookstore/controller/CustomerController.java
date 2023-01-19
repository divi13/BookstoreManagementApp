package com.cg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.service.ICustomerService;
import com.cg.bookstore.entity.Customer;

@CrossOrigin("http://localhost:3000")
@RestController
public class CustomerController {

	@Autowired
	private ICustomerService icustomerService;
	
	@PostMapping("/customer/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer newCustomer = icustomerService.createCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/customer/all")
	public List<Customer> fetchAllCustomers() {
		List<Customer> list = icustomerService.listCustomers();
		return list;
	}
	
	@GetMapping("/customer/get/{id}")
	public ResponseEntity<Object> fetchCustomerDetailsById(@PathVariable("id") int customerId){
		ResponseEntity<Object> responseEntity=null;
		Customer customer=icustomerService.viewCustomer(customerId);
		responseEntity=new ResponseEntity<>(customer,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/customer/update")
	public ResponseEntity<Object> modifyCustomer(@RequestBody Customer customer){
		ResponseEntity<Object> responseEntity=null;
		Customer updatedCustomer=icustomerService.updateCustomer(customer);
		responseEntity =new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable("id")int customer){
		ResponseEntity<String> responseEntity=null;
		icustomerService.deleteCustomer(customer);
		responseEntity=new ResponseEntity<>("customer deleted",HttpStatus.OK);
		return responseEntity;
	}

}
