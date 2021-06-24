package com.va.service;

import com.va.model.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {

    private static final String url = "http://localhost:8081/books";
    @Autowired
    private RestTemplate restTemplate;

    public BookDTO addNewBook(BookDTO book) {

        HttpEntity<BookDTO> request = new HttpEntity<>(book);
        return restTemplate.postForObject(url, request, BookDTO.class);

    }

    public BookDTO getBookById(Long id) {

        BookDTO book = restTemplate.getForObject(url + "/" + id, BookDTO.class);
        return book;
    }

    public List<BookDTO> getAllBooks() {
        ResponseEntity<List<BookDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BookDTO>>() {
                });
        List<BookDTO> books = response.getBody();
        return books;
    }

    public void updateBook(Long id, BookDTO book) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String resourceUrl =
                url + '/' + book.getBookId();
        HttpEntity<BookDTO> requestUpdate = new HttpEntity<>(book, headers);
        restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
    }

    public void deleteBook(Long id, BookDTO book) {

        String entityUrl = url + "/" + book.getBookId();
        restTemplate.delete(entityUrl);

    }
}
