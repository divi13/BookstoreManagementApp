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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entity.Review;
import com.cg.bookstore.service.IReviewService;

@CrossOrigin("http://localhost:3000")
@RestController
public class ReviewController {

	@Autowired
	private IReviewService ireviewService;
	
	@PostMapping("/review/save/{book_id}")
	public ResponseEntity<Review> addReview(@PathVariable("book_id") int bookId,@RequestBody Review r) {
		Review newReview = ireviewService.addReview(bookId,r);
		ResponseEntity<Review> responseEntity = new ResponseEntity<>(newReview, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/review/{id}")
	public ResponseEntity<String> removeReview(@PathVariable("id")int b){
		ResponseEntity<String> responseEntity=null;
			ireviewService.deleteReview(b);
			responseEntity=new ResponseEntity<>("review deleted",HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/review/all")
	public List<Review> fetchAllReviews(){
		List<Review> list=ireviewService.listAllReviews();
		return list;
	}
	
	@PutMapping("review/update")
	public ResponseEntity<Object> updateReview(@RequestBody Review r){
		ResponseEntity<Object> responseEntity=null;
		Review updatedReview=ireviewService.updateReview(r);
		responseEntity =new ResponseEntity<>(updatedReview,HttpStatus.OK);
	return responseEntity;
	}
	
	@GetMapping("/review/bycustomer/{id}")
    public List<Review> getReviewByCustomer(@PathVariable("id") int customerId)
    {
        List<Review> review=ireviewService.listAllReviewsByCustomer(customerId);
        return review;
    }
	
	@GetMapping("/review/{id}")
	public ResponseEntity<Object> fetchBookDetails(@PathVariable("id") int r){
		ResponseEntity<Object> responseEntity=null;
		Review review=ireviewService.viewReview(r);
		responseEntity=new ResponseEntity<>(review,HttpStatus.OK);
		return responseEntity;
	}
}
