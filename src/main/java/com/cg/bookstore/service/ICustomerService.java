package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;

public interface ICustomerService {

	public Customer createCustomer(Customer c);
	public List<Customer> listCustomers();
	public void deleteCustomer(int c);
	public Customer updateCustomer(Customer c);
	public Customer viewCustomer(int c);
}
