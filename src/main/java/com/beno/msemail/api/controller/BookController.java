package com.beno.msemail.api.controller;

import com.beno.msemail.api.mapper.BookMapper;
import com.beno.msemail.api.request.BookRequest;
import com.beno.msemail.api.response.BookResponse;
import com.beno.msemail.domain.entity.Book;
import com.beno.msemail.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {


    private final BookService service;

    private final BookMapper bookMapper;



    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id) {
        try {

            Optional<Book> book = service.get(id);

            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAll() {
        try {

            List<Book> bookList = service.listAll();
            List<BookResponse> bookResponse = bookMapper.toBookResponseList(bookList);

            return ResponseEntity.ok(bookResponse);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookResponse> add(@RequestBody BookRequest bookRequest) {
        Book book = bookMapper.toBook(bookRequest);
        service.save(book);
        BookResponse bookResponse = bookMapper.toBookResponse(book);
        return ResponseEntity.ok(bookResponse);

    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookResponse> update(@RequestBody BookRequest bookRequest, @PathVariable Integer id) {
        try {
            //verficar se existe
           Optional<Book> existe= service.get(id);
            Book book = bookMapper.toBook(bookRequest);
             Book savedBook=  service.update(id,book);
            BookResponse bookResponse=bookMapper.toBookResponse(savedBook);

            return  ResponseEntity.ok(bookResponse);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Optional<Book> existBook = service.get(id);
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
