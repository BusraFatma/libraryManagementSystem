package com.lms.lms.dtos.request;

import com.lms.lms.data.models.Author;
import com.lms.lms.data.models.Book;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateBookRequest {
    private String bookName;
    private int quantity;
    private List <Long> authorIds;
    private Long isbn;
    private String yearPublished;
//    private String bookName;
//    private int quantity;
//    private Long isbn;
//    private String yearPublished;
//    private List<Author> authors;
//    private Book book;

}
