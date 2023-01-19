package com.cg.bookstore.servicetest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bookstore.repository.ICustomerRepository;
import com.cg.bookstore.service.ICustomerServiceImpl;

@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	private ICustomerServiceImpl icustomerServiceImpl=new ICustomerServiceImpl();
	
	@Mock
	private ICustomerRepository iCustomerRepository;
	
	@Test
	public void testGetCustomerById() {
		
	}
}
