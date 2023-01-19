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

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.service.IBookService;

@CrossOrigin("http://localhost:3000")
@RestController
public class BookController {
	@Autowired
	private IBookService ibookService;
	
	@PostMapping("/book/{category_id}/save")
	public ResponseEntity<Book> addBookInCategory(@PathVariable("category_id")int categoryId,@RequestBody Book book) {
		Book newBook = ibookService.createBook(categoryId,book);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(newBook, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/book/save")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book newBook = ibookService.createBook(book);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(newBook, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Object> fetchBookDetailsById(@PathVariable("id") int bookId){
		ResponseEntity<Object> responseEntity=null;
		Book book=ibookService.viewBook(bookId);
		responseEntity=new ResponseEntity<>(book,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/book/update")
	public ResponseEntity<Object> modifyBook(@RequestBody Book book){
		ResponseEntity<Object> responseEntity=null;
		Book updatedBook=ibookService.editBook(book);
		responseEntity =new ResponseEntity<>(updatedBook,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> removeProduct(@PathVariable("id")int bookId){
		ResponseEntity<String> responseEntity=null;
		ibookService.deleteBook(bookId);
		responseEntity=new ResponseEntity<>("product deleted",HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/book/all")
	public List<Book> fetchAllBooks(){
		List<Book> list=ibookService.listAllBooks();
		return list;
	}
	
	@GetMapping("/book/name/{name}")
	public ResponseEntity<Book> getBookByName(@PathVariable("name") String bookName){
		
		ResponseEntity<Book> responseEntity=null;
		Book book=ibookService.getByName(bookName);
		responseEntity = new ResponseEntity<>(book, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/book/bycategory/{category_name}")
    public List<Book> getBookByCategory(@PathVariable("category_name") String categoryName)
    {
        List<Book> book=ibookService.listBooksByCategory(categoryName);
        return book;
    }
	
}
