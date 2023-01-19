package com.cg.bookstore.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_tbl")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="email")
    private String email;

    @Column(name="fullname")
    private String fullName;

    @Column(name="password")
    private String password;

    @Column(name="mobile")
    private String mobileNumber;

    @Column(name="register_on")
    private LocalDate registerOn;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
    
//    @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL)
//    private List<BookOrder> bookOrder;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getRegisterOn() {
		return registerOn;
	}

	public void setRegisterOn(LocalDate registerOn) {
		this.registerOn = registerOn;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	public List<BookOrder> getBookOrder() {
//		return bookOrder;
//	}
//
//	public void setBookOrder(List<BookOrder> bookOrder) {
//		this.bookOrder = bookOrder;
//	}
}
