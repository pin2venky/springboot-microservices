package com.va.controller;

import com.va.model.BookDTO;
import com.va.service.BookService;
import com.va.service.LibraryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Library Controller")
@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "Add a new book")
    @PostMapping("/library/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewBook(@Valid @RequestBody BookDTO book) {
        bookService.addNewBook(book);
    }


    @ApiOperation(value = "Login")
    @GetMapping("/library")
    public void login() {

    }

    @ApiOperation(value = "List of all books")
    @GetMapping("/library/books")
    public List<BookDTO> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @ApiOperation(value = "Get a book's details")
    @GetMapping("library/books/{bookId}")
    public BookDTO getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }


    @ApiOperation(value = "Update a book")
    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable Long id,
                           @Valid @RequestBody BookDTO book) {
        bookService.updateBook(id, book);
    }

    @ApiOperation(value = "Delete a book")
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id,
                           @Valid @RequestBody BookDTO book) {
        bookService.deleteBook(id, book);
    }

}
