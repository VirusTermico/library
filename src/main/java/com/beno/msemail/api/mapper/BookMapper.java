package com.beno.msemail.api.mapper;

import com.beno.msemail.api.request.BookRequest;
import com.beno.msemail.api.response.BookResponse;
import com.beno.msemail.domain.entity.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookMapper {

    public final ModelMapper mapper;

    public Book toBook(BookRequest bookRequest) {

        return mapper.map(bookRequest, Book.class);
    }

    public BookResponse toBookResponse(Book book) {

        return mapper.map(book, BookResponse.class);
    }


    public List<BookResponse> toBookResponseList(List<Book> bookList) {

        return bookList.stream().map(this::toBookResponse).collect(Collectors.toList());
    }
}
