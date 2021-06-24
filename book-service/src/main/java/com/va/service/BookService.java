package com.va.service;

import com.va.domain.Book;
import com.va.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public void addNewBook(Book book) {
        this.bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return this.bookRepository.findById(id).orElse(new Book());
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book updateBook(Long id, Book book) {
        if(this.bookRepository.findById(id).isPresent()){
           return this.bookRepository.save(book);
        }
        return book;
    }

    public void deleteBook(Long id, Book book) {
        if(this.bookRepository.findById(id).isPresent()){
             this.bookRepository.delete(book);
        }
    }
}
