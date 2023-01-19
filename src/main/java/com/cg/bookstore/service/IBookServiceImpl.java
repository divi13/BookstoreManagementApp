package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.BookNotFoundException;
import com.cg.bookstore.exception.CategoryNotFoundException;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.ICategoryRepository;

@Service
public class IBookServiceImpl implements IBookService{

	@Autowired
	private IBookRepository ibookRepository;
	
	@Autowired
	private ICategoryRepository iCategoryRepository;
	
	@Override
	public Book createBook(int categoryId,Book book) {
		Optional<Category> optionalCategory=iCategoryRepository.findById(categoryId);
		if(optionalCategory.isEmpty()) {
			throw new CategoryNotFoundException("category not found with id :"+categoryId);
		}
		Category category=optionalCategory.get();
		book.setCategory(category);
		Book newbook=ibookRepository.save(book);
		return newbook;
	}

	@Override
	public List<Book> listAllBooks() {
		return ibookRepository.findAll();
	}

	@Override
	public void deleteBook(int book) {
		Optional<Book>optionalBook= ibookRepository.findById(book);
		if(optionalBook.isEmpty()) {
			throw new BookNotFoundException("book not found with id :"+book);
		}
		ibookRepository.deleteById(book);
	}

	@Override
	public Book editBook(Book book) {
		Optional<Book> optionalBook= ibookRepository.findById(book.getBookId());
		if(optionalBook.isEmpty()) {
			throw new BookNotFoundException("book not found with id :"+book.getBookId());
		}
		Book updateBook=ibookRepository.save(book);
		return updateBook;
	}

	@Override
	public Book viewBook(int bookId) {
		Optional<Book> optionalBook= ibookRepository.findById(bookId);
		if(optionalBook.isEmpty()) {
			throw new BookNotFoundException("book not found with id :"+bookId);
		}
		Book book=optionalBook.get();
		return book;
	}

	@Override
	public Book getByName(String name) {
		Book book=ibookRepository.findByTitle(name);
		return book;
	}

	@Override
	public Book createBook(Book book) {
		Book newbook=ibookRepository.save(book);
		return newbook;
	}

	 @Override
	    public List<Book> listBooksByCategory(String category) {
	        List<Book> list=ibookRepository.findByCategoryCategoryName(category);
	        return list;
	    }
}
