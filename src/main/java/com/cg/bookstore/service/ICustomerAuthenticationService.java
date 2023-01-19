package com.cg.bookstore.service;

import com.cg.bookstore.entity.Customer;

public interface ICustomerAuthenticationService {
	

	public Customer login(String email,String password );

	 

	}

