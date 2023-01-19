package com.lms.lms.services;

import com.lms.lms.data.models.Author;
import com.lms.lms.data.models.Book;
import com.lms.lms.dtos.request.CreateAuthorRequest;
import com.lms.lms.dtos.request.UpdateAuthorRequest;
import com.lms.lms.dtos.response.CreateAuthorResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthorServiceImplTest {
    @Autowired
    private AuthorService authorService;
    private CreateAuthorResponse createAuthorResponse;
    private CreateAuthorRequest createAuthorRequest;

    Author author1;

    Author author2;

    @BeforeEach
    void setUp() {
//        authorService.deleteAll();
        createAuthorRequest = new CreateAuthorRequest();
        createAuthorRequest.setEmail("author@gmail.com");
        createAuthorRequest.setFirstName("AuthorFirstName");
        createAuthorRequest.setLastName("AuthorLastName");
//        Book book = new Book();
//        book.setBookName("Chemistry");
////        List<Book> bookList = List.of(book);
//        author1 = new Author();
//        author1.setEmail("kabir@gmail.com");
//        author1.setFirstName("Kabir");
//        author2 = new Author();
//        author2.setEmail("ade@gmail.com");
//        author2.setLastName("Yusuf");
//        createAuthorRequest.setBook(book);
//        List<Author>authorList = List.of(author1,author2);
//        createAuthorRequest.setAuthors(authorList);
//        System.out.println(createAuthorRequest);
//        Book book = new Book();
//        book.setBookName("Chemistry");
//        createAuthorRequest.setBook(book);
    }

    @AfterEach
    void tearDown() {
        authorService.deleteAll();
    }
    @Test
    void testThatAuthorCanBeCreated(){
        createAuthorResponse = authorService.createAuthor(createAuthorRequest);
        assertNotNull(createAuthorResponse.getId());
//        System.out.println(createAuthorResponse.getId());
       assertEquals("Successful", createAuthorResponse.getMessage());
//       Author foundAuthor = authorService.getAuthorByEmail("author@gmail.com");
////       assertEquals(author1, foundAuthor);
//        System.out.println(foundAuthor);
////        assertEquals(1, author1.getBooks().size());
////       assertEquals(1, foundAuthor.getBooks().size());
    }
    @Test
    void findAuthorByEmail(){
        authorService.createAuthor(createAuthorRequest);
        Author foundAuthorOne = authorService.getAuthorByEmail("author@gmail.com");
//        Author foundAuthorTwo = authorService.getAuthorByEmail("ade@gmail.com");
        assertEquals("AuthorFirstName", foundAuthorOne.getFirstName());
//        assertEquals("Yusuf", foundAuthorTwo.getLastName());
    }
    @Test
    void deleteAuthorByEmail(){
        authorService.createAuthor(createAuthorRequest);
        List<Author> authorsBeforeDeletion = authorService.getAuthors();
        assertEquals(1, authorsBeforeDeletion.size());
        authorService.deleteAuthorByEmail("author@gmail.com");
        List<Author> authorsAfterDeletion = authorService.getAuthors();
        assertEquals(0, authorsAfterDeletion.size());
    }
    @Test
    void updateAuthorByEmail(){
        createAuthorResponse = authorService.createAuthor(createAuthorRequest);
        Author foundAuthorBeforeUpdate = authorService.getAuthorByEmail("author@gmail.com");
        assertEquals("AuthorFirstName", foundAuthorBeforeUpdate.getFirstName());
        assertEquals(0, foundAuthorBeforeUpdate.getBooks().size());

        UpdateAuthorRequest updateAuthorRequest = new UpdateAuthorRequest();

        Book book = new Book();
        book.setBookName("AuthorBook");
        book.setYearPublished("2022");
        book.setIsbn(1234L);
        book.setQuantity(3);

        updateAuthorRequest.setEmail("author@gmail.com");
        updateAuthorRequest.setFirstName("updatedAuthorFirstName");
        updateAuthorRequest.setBook(book);
        authorService.updateAuthorByEmail(updateAuthorRequest);
        Author foundAuthorAfterUpdate = authorService.getAuthorByEmail("author@gmail.com");
        assertEquals("updatedAuthorFirstName", foundAuthorAfterUpdate.getFirstName());
//        assertEquals("AuthorLastName", foundAuthorAfterUpdate.getLastName());
        assertEquals(1, foundAuthorAfterUpdate.getBooks().size());

    }
}