package com.codingdojo.mvc.controllers;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book addBook(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("language") String language,
            @RequestParam("numberOfPages") Integer numberOfPages
    ) {
        return bookService.createBook(title, description, language, numberOfPages);
    }

    @RequestMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.findBookById(id);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public Book editBookById(
            @PathVariable("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("language") String language,
            @RequestParam("numberOfPages") Integer numberOfPages
    ) {
        return bookService.updateBookById(id, title, description, language, numberOfPages);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void removeBookById(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
    }
}
