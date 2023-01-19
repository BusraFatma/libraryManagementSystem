package com.lms.lms.dtos.request;

import com.lms.lms.data.models.Book;
import lombok.Data;

import java.util.List;

@Data
public class AddBookRequest {
    private Book book;
    private List<Long>authorIds;
}
