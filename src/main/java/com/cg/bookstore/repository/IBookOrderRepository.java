package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entity.BookOrder;
import com.cg.bookstore.entity.OrderDetails;

@Repository
public interface IBookOrderRepository extends JpaRepository<BookOrder, Integer>{
	public List<BookOrder> findByCustomerCustomerId(int cs);
}
