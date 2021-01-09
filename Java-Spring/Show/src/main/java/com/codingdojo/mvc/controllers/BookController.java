package com.codingdojo.mvc.controllers;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "booksList.jsp";
    }

    @RequestMapping("/add")
    public String showAddForm(@ModelAttribute("book") Book book) {
        return "addBookForm.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/books/add";
        }
        bookService.createUpdateBook(book);
        return "redirect:/books";
    }

    @RequestMapping("/{id}")
    public String showBookInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findBookById(id));
        return "bookInfo.jsp";
    }

    @RequestMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findBookById(id));
        return "editBookForm.jsp";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String editBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/books/" + id + "/edit";
        }
        book.setId(id);
        bookService.createUpdateBook(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String removeBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }
}
