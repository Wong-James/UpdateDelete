package com.james.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.stereotype.Service;

import com.james.mvc.models.Book;
import com.james.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}
    
    
    
}
