package com.cg.bookstore.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bookstore.entity.Address;
import com.cg.bookstore.entity.BookOrder;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.entity.OrderDetails;
import com.cg.bookstore.repository.IBookOrderRepository;
import com.cg.bookstore.repository.IOrderRepository;
import com.cg.bookstore.service.IOrderServiceImpl;

@SpringBootTest
public class OrderServiceTest1 {

	@Mock
	private IBookOrderRepository ibookOrderRepository;
	
	@Mock
	private IOrderRepository iorderRepository;
	
	@InjectMocks
	private IOrderServiceImpl iorderServiceImpl=new IOrderServiceImpl();
	
	@Test
	public void testAddBookOrder() {
		BookOrder bo=new BookOrder();
		bo.setOrderId(1);
		bo.setStatus("paid");
		bo.setOrderDate(LocalDate.now());
		bo.setPaymentMethod("cash");
		bo.setRecipientName("raj");
		bo.setRecipientPhone("8185091660");
		
		Customer c=new Customer();
		c.setCustomerId(1);
		c.setEmail("raj@gmail.com");
		c.setFullName("yuvaraj");
		c.setMobileNumber("8185091669");
		c.setPassword("raj");
		c.setRegisterOn(LocalDate.now());
		
		Address a=new Address();
		a.setAddressId(1);
		a.setAddressName("abc layout");
		a.setCity("chennai");
		a.setCountry("india");
		a.setPincode("534134");
		
		c.setAddress(a);
		bo.setCustomer(c);
		
		when(ibookOrderRepository.save(bo)).thenReturn(bo);
		assertEquals("paid",bo.getStatus());
		assertEquals("raj", bo.getRecipientName());
		assertEquals(1,bo.getOrderId());
		assertEquals("abc layout",bo.getCustomer().getAddress().getAddressName());
	}
	
	@Test
	public void testAddOrderDetails() {
		OrderDetails od=new OrderDetails();
		od.setBookId(11);
		od.setOrderDetailsId(1152);
		od.setQuantity(2);
		od.setTotal(1000);
		
		when(iorderRepository.save(od)).thenReturn(od);
		assertEquals(1152,od.getOrderDetailsId());
		assertEquals(11,od.getBookId());
		assertEquals(2,od.getQuantity());
	}
	
	@Test
	public void testGetOrderDetailsById() {
		OrderDetails od=new OrderDetails();
		od.setBookId(11);
		od.setOrderDetailsId(1152);
		od.setQuantity(2);
		od.setTotal(1000);
		
		when(iorderRepository.findById(1152)).thenReturn(Optional.of(od));
		assertEquals(11,od.getBookId());
		assertEquals(1000,od.getTotal());
		assertEquals(1000,od.getTotal());
	}
	
	@Test
	public void testListOrderDetails() {
		List<OrderDetails> od=new ArrayList<OrderDetails>();
		OrderDetails o=new OrderDetails();
		o.setBookId(11);
		o.setOrderDetailsId(1152);
		o.setQuantity(2);
		o.setTotal(1000);
		
		BookOrder bo=new BookOrder();
		bo.setOrderId(1);
		bo.setStatus("paid");
		bo.setOrderDate(LocalDate.now());
		bo.setPaymentMethod("cash");
		bo.setRecipientName("raj");
		bo.setRecipientPhone("8185091660");
		
		Customer c=new Customer();
		c.setCustomerId(1);
		c.setEmail("raj@gmail.com");
		c.setFullName("yuvaraj");
		c.setMobileNumber("8185091669");
		c.setPassword("raj");
		c.setRegisterOn(LocalDate.now());
		
		Address a=new Address();
		a.setAddressId(1);
		a.setAddressName("abc layout");
		a.setCity("chennai");
		a.setCountry("india");
		a.setPincode("534134");
		
		c.setAddress(a);
		bo.setCustomer(c);
		o.setBookOrder(bo);
		
		OrderDetails o1=new OrderDetails();
		o1.setBookId(12);
		o1.setOrderDetailsId(1252);
		o1.setQuantity(2);
		o1.setTotal(1000);
		
		BookOrder bo1=new BookOrder();
		bo1.setOrderId(1);
		bo1.setStatus("processing");
		bo1.setOrderDate(LocalDate.now());
		bo1.setPaymentMethod("online");
		bo1.setRecipientName("divya");
		bo1.setRecipientPhone("8185091660");
		
		Customer c1=new Customer();
		c1.setCustomerId(1);
		c1.setEmail("raj@gmail.com");
		c1.setFullName("yuvaraj");
		c1.setMobileNumber("8185091669");
		c1.setPassword("raj");
		c1.setRegisterOn(LocalDate.now());
		
		Address a1=new Address();
		a1.setAddressId(1);
		a1.setAddressName("xyz layout");
		a1.setCity("chennai");
		a1.setCountry("india");
		a1.setPincode("534134");
		
		c1.setAddress(a1);
		bo1.setCustomer(c1);
		o1.setBookOrder(bo);
		od.add(o);
		od.add(o1);
		
		when(iorderRepository.findAll()).thenReturn(od);
		assertEquals(12,o1.getBookId());
		assertEquals(2,od.size());
	}
	
	@Test
	public void testListOrdersByCustomer() {
		List<BookOrder> bo=new ArrayList<BookOrder>();
		
		BookOrder bo1=new BookOrder();
		bo1.setOrderId(1);
		bo1.setStatus("paid");
		bo1.setOrderDate(LocalDate.now());
		bo1.setPaymentMethod("cash");
		bo1.setRecipientName("raj");
		bo1.setRecipientPhone("8185091660");
		
		Customer c=new Customer();
		c.setCustomerId(1);
		c.setEmail("raj@gmail.com");
		c.setFullName("yuvaraj");
		c.setMobileNumber("8185091669");
		c.setPassword("raj");
		c.setRegisterOn(LocalDate.now());
		
		Address a=new Address();
		a.setAddressId(1);
		a.setAddressName("abc layout");
		a.setCity("chennai");
		a.setCountry("india");
		a.setPincode("534134");
		
		c.setAddress(a);
		bo1.setCustomer(c);
		
		BookOrder bo2=new BookOrder();
		bo2.setOrderId(2);
		bo2.setStatus("processing");
		bo2.setOrderDate(LocalDate.now());
		bo2.setPaymentMethod("online");
		bo2.setRecipientName("divya");
		bo2.setRecipientPhone("8185091660");
		
		Customer c1=new Customer();
		c1.setCustomerId(2);
		c1.setEmail("divya@gmail.com");
		c1.setFullName("divya");
		c1.setMobileNumber("8185091669");
		c1.setPassword("raj");
		c1.setRegisterOn(LocalDate.now());
		
		Address a1=new Address();
		a1.setAddressId(1);
		a1.setAddressName("xyz layout");
		a1.setCity("chennai");
		a1.setCountry("india");
		a1.setPincode("534134");
		
		c1.setAddress(a1);
		bo2.setCustomer(c1);
		bo.add(bo1);
		bo.add(bo2);
		
		when(ibookOrderRepository.findByCustomerCustomerId(1)).thenReturn(bo);
		assertEquals("cash",bo1.getPaymentMethod());
		assertEquals("divya",bo.get(1).getCustomer().getFullName());
		assertEquals(2,bo.size());
	}
	
	@Test
	public void testListOrdersByBook() {
		List<OrderDetails> od=new ArrayList<OrderDetails>();
		
		OrderDetails o=new OrderDetails();
		o.setBookId(11);
		o.setOrderDetailsId(1152);
		o.setQuantity(2);
		o.setTotal(1000);
		
		BookOrder bo1=new BookOrder();
		bo1.setOrderId(1);
		bo1.setStatus("paid");
		bo1.setOrderDate(LocalDate.now());
		bo1.setPaymentMethod("cash");
		bo1.setRecipientName("raj");
		bo1.setRecipientPhone("8185091660");
		
		Customer c=new Customer();
		c.setCustomerId(1);
		c.setEmail("raj@gmail.com");
		c.setFullName("yuvaraj");
		c.setMobileNumber("8185091669");
		c.setPassword("raj");
		c.setRegisterOn(LocalDate.now());
		
		Address a=new Address();
		a.setAddressId(1);
		a.setAddressName("abc layout");
		a.setCity("chennai");
		a.setCountry("india");
		a.setPincode("534134");
		
		c.setAddress(a);
		bo1.setCustomer(c);
		
		OrderDetails o1=new OrderDetails();
		o1.setBookId(11);
		o1.setOrderDetailsId(1152);
		o1.setQuantity(2);
		o1.setTotal(1000);
		
		BookOrder bo2=new BookOrder();
		bo2.setOrderId(2);
		bo2.setStatus("processing");
		bo2.setOrderDate(LocalDate.now());
		bo2.setPaymentMethod("online");
		bo2.setRecipientName("divya");
		bo2.setRecipientPhone("8185091660");
		
		Customer c1=new Customer();
		c1.setCustomerId(2);
		c1.setEmail("divya@gmail.com");
		c1.setFullName("divya");
		c1.setMobileNumber("8185091669");
		c1.setPassword("raj");
		c1.setRegisterOn(LocalDate.now());
		
		Address a1=new Address();
		a1.setAddressId(1);
		a1.setAddressName("xyz layout");
		a1.setCity("chennai");
		a1.setCountry("india");
		a1.setPincode("534134");
		
		c1.setAddress(a1);
		bo2.setCustomer(c1);
		o.setBookOrder(bo1);
		o1.setBookOrder(bo2);
		od.add(o);
		od.add(o1);
		
		when(iorderRepository.findByBookId(11)).thenReturn(od);
		assertEquals(1152,o.getOrderDetailsId());
		assertEquals(2,od.size());
	}
	
	@Test
	public void testDeleteOrder() {
		OrderDetails od=new OrderDetails();
		od.setOrderDetailsId(1);
		od.setBookId(1);
		od.setQuantity(2);
		od.setTotal(1000);
		
		when(iorderRepository.findById(1)).thenReturn(Optional.of(od));
		doNothing().when(iorderRepository).deleteById(1);
		
		iorderServiceImpl.cancelOrder(1);
		
		verify(iorderRepository,times(1)).findById(1);
		verify(iorderRepository,times(1)).deleteById(1);
	}
}

