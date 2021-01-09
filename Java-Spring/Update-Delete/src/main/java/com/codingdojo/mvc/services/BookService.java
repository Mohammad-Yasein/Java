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

    public Book createBook(String title, String description, String language, Integer numberOfPages) {
        return bookRepository.save(new Book(title, description, language, numberOfPages));
    }

    public Book findBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public Book updateBookById(Long id, String title, String description, String language, Integer numberOfPages) {
        Book book = findBookById(id);
        if (book == null) {
            return null;
        }
        book.setTitle(title);
        book.setDescription(description);
        book.setLanguage(language);
        book.setNumberOfPages(numberOfPages);
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
