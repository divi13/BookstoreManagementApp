package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.entity.OrderDetails;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails, Integer>{
	
	public List<OrderDetails> findByBookId(int book);
}
