package com.cg.bookstore.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entity.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer>{

	public Book findByTitle(String title);
	public List<Book> findByCategoryCategoryName(String a);
}
