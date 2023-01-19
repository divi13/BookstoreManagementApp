package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.BookOrder;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.entity.OrderDetails;

public interface IOrderService {

	public List<OrderDetails> listAllOrders();
	public List<BookOrder> listOrderByCustomer(int cs);
	public void cancelOrder(int od);
	public BookOrder addOrder(int c,BookOrder od);
	public OrderDetails addOrderDetails(int o,OrderDetails od);
	public List<OrderDetails> viewOrderByBook(int book);
	public OrderDetails getOrderById(int order);


}
