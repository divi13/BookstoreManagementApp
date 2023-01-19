package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.entity.Review;
import com.cg.bookstore.exception.BookNotFoundException;
import com.cg.bookstore.exception.CategoryNotFoundException;
import com.cg.bookstore.exception.ReviewNotFoundException;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.IReviewRepository;

@Service
public class IReviewServiceImpl implements IReviewService{
	
	@Autowired
	private IReviewRepository ireviewRepository;
	
	@Autowired
	private IBookRepository ibookRepository;
	
	@Override
	public List<Review> listAllReviews() {
		return ireviewRepository.findAll();
	}

	@Override
	public Review addReview(int bookId,Review review) {
		Optional<Book> optionalBook=ibookRepository.findById(bookId);
		if(optionalBook.isEmpty()) {
			throw new BookNotFoundException("book not found with id :"+bookId);
		}
		Book book=optionalBook.get();
		review.setBook(book);
		Review newReview=ireviewRepository.save(review);
		return newReview;
	}

	@Override
	public void deleteReview(int reviewId) {
		Optional<Review> review=ireviewRepository.findById(reviewId);
		if(review.isEmpty()) {
			throw new ReviewNotFoundException("no review found");
		}
		ireviewRepository.deleteById(reviewId);
	}

	@Override
	public Review updateReview(Review review) {
		Optional<Review> optionalReview=ireviewRepository.findById(review.getReviewId());
		if(optionalReview.isEmpty()) {
			throw new ReviewNotFoundException("no review found");
		}
		Review updatedReview=ireviewRepository.save(review);
		return updatedReview;
	}

	@Override
	public Review viewReview(int review) {
		Optional<Review> optionalReview= ireviewRepository.findById(review);
		if(optionalReview.isEmpty()) {
			throw new ReviewNotFoundException("review not found with id :"+review);
		}
		Review review1=optionalReview.get();
		return review1;
	}
	
	 @Override
	    public List<Review> listAllReviewsByCustomer(int i) {
	        List<Review> list=ireviewRepository.findByCustomerId(i);
	        return list;
	    }
}
