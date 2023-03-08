package com.beno.msemail.api.request;

import com.beno.msemail.domain.enums.BookStatus;
import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private String publisher;
    private BookStatus status;

}
