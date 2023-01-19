package com.lms.lms.services;

import com.lms.lms.data.models.Book;
import com.lms.lms.dtos.request.CreateBookRequest;
import com.lms.lms.dtos.response.CreateBookResponse;


import java.util.List;

public interface BookService {
    CreateBookResponse createBook(CreateBookRequest createBookRequest);
    String deleteBookById();
    String deleteAllBooks();
    String deleteBookByIsbn();
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book getBookByIsbn(Long isbn);

    Book getBookByName(String bookName);
    List<Book> getBooksByAuthor(String authorName);
    List<Book> getListOfBooksByAuthors(Long authorId);


    void deleteAll();
}
