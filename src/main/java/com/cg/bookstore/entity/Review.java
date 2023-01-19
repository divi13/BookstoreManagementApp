package com.cg.bookstore.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review_tbl")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_id")
    private int reviewId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="book_id")
    private Book book;

    @Column(name="customer_id")
    private int customerId;

    @Column(name="head_line")
    private String headLine;

    @Column(name="comment")
    private String comment;

    @Column(name="rating")
    private double rating;

    @Column(name="review_on")
    private LocalDate reviewOn;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public LocalDate getReviewOn() {
		return reviewOn;
	}

	public void setReviewOn(LocalDate reviewOn) {
		this.reviewOn = reviewOn;
	}
}
