package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.exception.CustomerNotFoundException;
import com.cg.bookstore.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerRepository icustomerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		Customer newcustomer=icustomerRepository.save(customer);
		return newcustomer;
	}

	@Override
	public List<Customer> listCustomers() {
		
		return icustomerRepository.findAll();
	}

	@Override
	public void deleteCustomer(int customer) {
		Optional<Customer> optionalCustomer= icustomerRepository.findById(customer);
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("customer not found with id :"+customer);
		}
		icustomerRepository.deleteById(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> optionalCustomer= icustomerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("customer not found with id :"+customer.getCustomerId());
		}
		Customer updateCustomer=icustomerRepository.save(customer);
		return updateCustomer;
	}

	@Override
	public Customer viewCustomer(int customerId) {
		Optional<Customer> optionalCustomer= icustomerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("customer not found with id :"+customerId);
		}
		Customer customer=optionalCustomer.get();
		return customer;
	}

}
