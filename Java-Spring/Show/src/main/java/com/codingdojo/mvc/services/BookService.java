package com.codingdojo.mvc.services;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public void createUpdateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
