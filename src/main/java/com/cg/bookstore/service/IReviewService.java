package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;
import com.cg.bookstore.entity.Review;

public interface IReviewService {

	public List<Review> listAllReviews();
	public Review addReview(int b,Review review);
	public void deleteReview(int review);
	public Review updateReview(Review review);
	public Review viewReview(int review);
	public List<Review> listAllReviewsByCustomer(int i);

}
