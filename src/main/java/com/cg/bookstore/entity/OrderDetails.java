package com.cg.bookstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book")
    @SequenceGenerator(name = "book",sequenceName = "book",initialValue = 1001)
    @Column(name="orderdetails_id")
    private int orderDetailsId;

    @Column(name="book_id")
    private int bookId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private BookOrder bookOrder;

    @Column(name="quantity")
    private int quantity;

    @Column(name="total")
    private double total;

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public BookOrder getBookOrder() {
		return bookOrder;
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
