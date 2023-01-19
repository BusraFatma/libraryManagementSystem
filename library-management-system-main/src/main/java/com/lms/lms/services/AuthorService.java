package com.lms.lms.services;

import com.lms.lms.data.models.Author;
import com.lms.lms.dtos.request.CreateAuthorRequest;
import com.lms.lms.dtos.request.UpdateAuthorRequest;
import com.lms.lms.dtos.response.CreateAuthorResponse;
import com.lms.lms.dtos.response.UpdateAuthorResponse;

import java.util.List;


public interface AuthorService {
    CreateAuthorResponse createAuthor(CreateAuthorRequest createAuthorRequest);
    Author getAuthorById(Long id);
    Author getAuthorByEmail(String email);

    Author findAuthorById(Long id);

    List<Author> getAllAuthorsById(List<Long>ids);

    void deleteAll();

    List<Author> getAuthors();
    String deleteAuthorByEmail(String email);

    UpdateAuthorResponse updateAuthorByEmail(UpdateAuthorRequest updateAuthorRequest);
}
