package com.cg.bookstore.repository;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("select  c from Customer c where c.email=:cId and c.password=:pwd")
	Optional<Customer> login(@Param("cId")String email,@Param("pwd") String password);
	Optional<Customer> findByEmail(String email);
}
