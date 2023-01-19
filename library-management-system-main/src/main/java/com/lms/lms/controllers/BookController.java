package com.lms.lms.controllers;

import com.lms.lms.data.models.Author;
import com.lms.lms.data.models.Book;
import com.lms.lms.dtos.request.CreateBookRequest;
import com.lms.lms.dtos.response.CreateBookResponse;
import com.lms.lms.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public CreateBookResponse createBook(@RequestBody CreateBookRequest createBookRequest){
        return  bookService.createBook(createBookRequest);
    }
    @GetMapping("/get-books-by-author/{authorId}")
    public List<Book> getBooksByAuthorId(@PathVariable Long authorId){
       return bookService.getListOfBooksByAuthors(authorId);
    }
}
