package com.va.controller;

import com.va.domain.Book;
import com.va.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Book Controller")
@RestController
public class BookController {


    @Autowired
    private BookService bookService;

    @ApiOperation(value = "Add New Book")
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewBook(@Valid @RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @ApiOperation(value = "Get Book By Id")
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }


    @ApiOperation(value = "Get All Books")
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @ApiOperation(value = "Update a book")
    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable Long id,
                           @Valid @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @ApiOperation(value = "Delete a book")
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id,
                           @Valid @RequestBody Book book) {
        bookService.deleteBook(id, book);
    }

}
