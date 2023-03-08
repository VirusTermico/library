package com.beno.msemail.domain.service;

import com.beno.msemail.domain.entity.Book;
import com.beno.msemail.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository repo;


    public List<Book> listAll() {
        return repo.findAll();
    }

    public Book save(Book book) {
        return repo.save(book);
    }

    public Optional<Book> get(Integer id) {
        return repo.findById(id);
    }

    public Book update(Integer id, Book book) {
        return save(book);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
