package com.lms.lms.controllers;

import com.lms.lms.data.models.Admin;
import com.lms.lms.data.models.Author;
import com.lms.lms.dtos.request.CreateAuthorRequest;
import com.lms.lms.dtos.response.CreateAuthorResponse;
import com.lms.lms.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<CreateAuthorResponse> createAuthor(@RequestBody CreateAuthorRequest createAuthorRequest){
        return new ResponseEntity<>(authorService.createAuthor(createAuthorRequest), HttpStatus.CREATED);

    }
    @GetMapping("/getAuthors")
    public ResponseEntity<List<Author>> getAuthors(){
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.CREATED);
    }
    @GetMapping("/findById/{authorId}")
    public ResponseEntity<Author> findAuthorById(@PathVariable("authorId") Long authorId){
        return new ResponseEntity<>(authorService.getAuthorById(authorId), HttpStatus.CREATED);
    }
}
