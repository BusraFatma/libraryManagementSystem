package com.lms.lms.dtos.response;

import lombok.Data;

@Data
public class CreateBookResponse {
    private Long id;
    private String bookName;
    private final String message = "Book added successfully";
}
