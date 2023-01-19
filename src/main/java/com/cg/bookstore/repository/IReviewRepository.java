package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.entity.Review;

public interface IReviewRepository extends JpaRepository<Review, Integer>{

	public List<Review> findByCustomerId(int c);
}
