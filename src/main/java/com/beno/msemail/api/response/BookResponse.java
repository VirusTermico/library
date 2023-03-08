package com.beno.msemail.api.response;

import com.beno.msemail.domain.enums.BookStatus;
import lombok.Data;

@Data
public class BookResponse {
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private BookStatus status;
}
