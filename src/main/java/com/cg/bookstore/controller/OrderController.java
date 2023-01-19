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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entity.BookOrder;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.entity.OrderDetails;
import com.cg.bookstore.service.IOrderService;

@CrossOrigin("http://localhost:3000")
@RestController
public class OrderController {

	@Autowired
	private IOrderService iorderService;
	
	@PostMapping("/order/save/{customer_id}")
	public ResponseEntity<BookOrder> addOrder(@PathVariable("customer_id")int customerId,@RequestBody BookOrder order) {
		BookOrder newOrder = iorderService.addOrder(customerId,order);
		ResponseEntity<BookOrder> responseEntity = new ResponseEntity<>(newOrder, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/orderdetails/{order_id}/add")
	public ResponseEntity<OrderDetails> addOrderDetails(@PathVariable("order_id")int orderId,@RequestBody OrderDetails order) {
		OrderDetails newOrder = iorderService.addOrderDetails(orderId,order);
		ResponseEntity<OrderDetails> responseEntity = new ResponseEntity<>(newOrder, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/orderDetails/all")
	public List<OrderDetails> fetchAllorders(){
		List<OrderDetails> list=iorderService.listAllOrders();
		return list;
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<String> removeOrder(@PathVariable("id")int od){
		ResponseEntity<String> responseEntity=null;
		iorderService.cancelOrder(od);
		responseEntity=new ResponseEntity<>("order deleted",HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/orderDetails/bybook/{id}")
    public List<OrderDetails> getOrderDetailsByBook(@PathVariable("id") int bookId)
    {
        List<OrderDetails> details=iorderService.viewOrderByBook(bookId);
        return details;
    }
	
	@GetMapping("/bookorder/bycustomer/get/{customer_id}")
    public List<BookOrder> getOrderByCustomer(@PathVariable("customer_id") int customerId)
    {
        List<BookOrder> order=iorderService.listOrderByCustomer(customerId);
        return order;
    }
	
	@GetMapping("/orderDetails/get/{id}")
	public ResponseEntity<Object> fetchOrderDetailsById(@PathVariable("id") int orderId){
		ResponseEntity<Object> responseEntity=null;
		OrderDetails order=iorderService.getOrderById(orderId);
		responseEntity=new ResponseEntity<>(order,HttpStatus.OK);
		return responseEntity;
	}
	
}
