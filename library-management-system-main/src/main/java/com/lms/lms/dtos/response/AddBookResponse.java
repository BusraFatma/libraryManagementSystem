package com.lms.lms.dtos.response;

import lombok.Data;

@Data
public class AddBookResponse {
    private final String message = "Book added successfully";
    private String bookName;
}
