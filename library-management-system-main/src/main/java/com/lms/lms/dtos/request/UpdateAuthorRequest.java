package com.lms.lms.dtos.request;

import com.lms.lms.data.models.Book;
import lombok.Data;

@Data
public class UpdateAuthorRequest {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Book book;
}
