package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.BookOrder;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.entity.OrderDetails;
import com.cg.bookstore.entity.Review;
import com.cg.bookstore.exception.CategoryNotFoundException;
import com.cg.bookstore.exception.CustomerNotFoundException;
import com.cg.bookstore.exception.OrderNotFoundException;
import com.cg.bookstore.repository.IBookOrderRepository;
import com.cg.bookstore.repository.ICustomerRepository;
import com.cg.bookstore.repository.IOrderRepository;

@Service
public class IOrderServiceImpl implements IOrderService{

	@Autowired
	public IOrderRepository iorderRepository;
	
	@Autowired
	private ICustomerRepository icustomerRepository;
	
	@Autowired
	public IBookOrderRepository ibookOrderRepository;
	
	@Override
	public List<OrderDetails> listAllOrders() {
		
		return iorderRepository.findAll();
	}
	
	@Override
	public List<BookOrder> listOrderByCustomer(int customerId) {
		List<BookOrder> list=ibookOrderRepository.findByCustomerCustomerId(customerId);
        return list;
	}
	
	@Override
	public void cancelOrder(int od) {
		Optional<OrderDetails> optionalOrder=iorderRepository.findById(od);
		if(optionalOrder.isEmpty()) {
			throw new CustomerNotFoundException("order not found with id :"+od);
		}
		iorderRepository.deleteById(od);
	}
	
	@Override
	public BookOrder addOrder(int customerId,BookOrder od) {
		Optional<Customer> optionalCustomer=icustomerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("customer not found with id :"+customerId);
		}
		Customer customer=optionalCustomer.get();
		od.setCustomer(customer);
		BookOrder newOrder=ibookOrderRepository.save(od);
		return newOrder;
	}
	
	@Override
	public List<OrderDetails> viewOrderByBook(int bookId) {
        List<OrderDetails> list=iorderRepository.findByBookId(bookId);
        return list;
	}

	@Override
	public OrderDetails addOrderDetails(int orderId,OrderDetails od) {
		Optional<BookOrder> optionalBookOrder=ibookOrderRepository.findById(orderId);
		if(optionalBookOrder.isEmpty()) {
			throw new OrderNotFoundException("order not found with id :"+orderId);
		}
		BookOrder order=optionalBookOrder.get();
		od.setBookOrder(order);
		OrderDetails newOrder=iorderRepository.save(od);
		return newOrder;
	}
	
	@Override
	public OrderDetails getOrderById(int od) {
		Optional<OrderDetails> optionalOrder=iorderRepository.findById(od);
		if(optionalOrder.isEmpty()) {
			throw new OrderNotFoundException("order not found with id :"+od);
		}
		OrderDetails order=optionalOrder.get();
		return order;
	}
}