package com.cg.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.exception.AuthenticationFailureException;
import com.cg.bookstore.exception.EmailNotExistingException;
import com.cg.bookstore.repository.ICustomerRepository;

@Service
public class ICustomerAuthenticationServiceImpl implements ICustomerAuthenticationService {
	
	@Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Customer login(String email, String password) {
        // TODO Auto-generated method stub
        Optional<Customer> optionalCustomer =iCustomerRepository.findByEmail(email);

        if(optionalCustomer.isEmpty())
        {
            throw new EmailNotExistingException("Customer not registered");
        }
        Customer customer = optionalCustomer.get();
        if(!password.equals(customer.getPassword()))
        {
            throw new AuthenticationFailureException("Login Failed");
        }
        return customer;
    }

 

}


