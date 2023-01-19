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

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.entity.OrderDetails;
import com.cg.bookstore.entity.Review;
import com.cg.bookstore.repository.IReviewRepository;
import com.cg.bookstore.service.IReviewServiceImpl;

@SpringBootTest
public class ReviewServiceTest {

	@Mock
	private IReviewRepository ireviewRepository;
	
	@InjectMocks
	private IReviewServiceImpl ireviewServiceImpl=new IReviewServiceImpl();
	
	@Test
    void testListAllReviews() {    
        List<Review> reviews = new ArrayList<>();
        Review review1 = new Review();
         review1.setReviewId(12);
          review1.setCustomerId(1);
          review1.setHeadLine("start");
          review1.setComment("good");
          review1.setRating(4);
          review1.setReviewOn(LocalDate.now());

        Review review2 = new Review();
         review2.setReviewId(13);
          review2.setCustomerId(1);
          review2.setHeadLine("thriller");
          review2.setComment("good");
          review2.setRating(5);
        review2.setReviewOn(LocalDate.now());

        Review review3 = new Review();
          review3.setReviewId(14);
          review3.setCustomerId(1);
          review3.setHeadLine("day");
          review3.setComment("good");
          review3.setRating(3);
          review3.setReviewOn(LocalDate.now());

        reviews.add(review3);
        reviews.add(review2);
        reviews.add(review1);

     when(ireviewRepository.findAll()).thenReturn(reviews);
       assertEquals("good",review1.getComment());
       assertEquals(3,reviews.size());
     }
	
	@Test
    public void testaddReview() {
      Review review = new Review();
      review.setReviewId(11);
      review.setCustomerId(1);
      review.setHeadLine("context");
      review.setComment("good");
      review.setRating(5);
      review.setReviewOn(LocalDate.now());
      
      Book b=new Book();
      b.setBookId(11);
      b.setAuthor("abc");
      b.setDescription("harry");
      b.setIsbn("12345");
      b.setTitle("harry potter");
      b.setPrice(500);
      b.setPublishDate(LocalDate.now());
      b.setLastUpdatedOn(LocalDate.now());
      
      Category c=new Category();
      c.setCategoryId(1);
      c.setCategoryName("fantasy");
      
      b.setCategory(c);
      review.setBook(b);

     when (ireviewRepository.save(review)).thenReturn(review);
     assertEquals(1,review.getCustomerId());
     assertEquals("context",review.getHeadLine());
     assertEquals("good",review.getComment());
     assertEquals(5,review.getRating());
     assertEquals(LocalDate.now(),review.getReviewOn());
    }
	
	@Test
    public void testViewReview() {
      Review review = new Review();
      review.setReviewId(11);
      review.setCustomerId(1);
      review.setHeadLine("context");
      review.setComment("good");
      review.setRating(5);
      review.setReviewOn(LocalDate.now());
      
      when(ireviewRepository.findById(11)).thenReturn(Optional.of(review));
      assertEquals(11,review.getReviewId());
	}
	
	@Test
    public void testListReviewByCustomer() {
      Review review = new Review();
      review.setReviewId(11);
      review.setCustomerId(1);
      review.setHeadLine("context");
      review.setComment("good");
      review.setRating(5);
      review.setReviewOn(LocalDate.now());
      
      when(ireviewRepository.findByCustomerId(1)).thenReturn(List.of(review));
      assertEquals(11,review.getReviewId());
	}
	
	@Test
	public void testDeletereview() {
		Review r=new Review();
		r.setReviewId(1);
		r.setCustomerId(1);
		r.setComment("good");
		r.setHeadLine("review");
		r.setRating(4);
		r.setReviewOn(LocalDate.now());
		
		when(ireviewRepository.findById(1)).thenReturn(Optional.of(r));
		doNothing().when(ireviewRepository).deleteById(1);
		
		ireviewServiceImpl.deleteReview(1);
		
		verify(ireviewRepository,times(1)).findById(1);
		verify(ireviewRepository,times(1)).deleteById(1);
	}
}
