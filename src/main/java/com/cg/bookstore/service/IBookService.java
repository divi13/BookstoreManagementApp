package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Category;

public interface IBookService {

	
	public Book createBook(int c,Book b);
	public Book createBook(Book b);
	public List<Book> listAllBooks();
	public void deleteBook(int b);
	public Book editBook(Book b);
	public Book viewBook(int b);
	public Book getByName(String name);
	public List<Book> listBooksByCategory(String cat);
	
}
