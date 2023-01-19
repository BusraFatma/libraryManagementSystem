package com.lms.lms.dtos.request;

import com.lms.lms.data.models.Author;
import com.lms.lms.data.models.Book;
import lombok.Data;

import java.util.List;

@Data
public class CreateAuthorRequest {
    private String firstName;
    private String lastName;
    private String email;
//    private Long authorId;
//    private List<Author> authors;
//    private Book book;
}
