package com.lms.lms.services;

import com.lms.lms.data.models.Admin;
import com.lms.lms.data.models.Author;
import com.lms.lms.data.models.Book;
import com.lms.lms.dtos.request.*;
import com.lms.lms.dtos.response.CreateAdminResponse;
import com.lms.lms.dtos.response.LoginResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

//    @MockBean
//    private AdminRepository adminRepository;
    private CreateAdminRequest createAdminRequest;

    private  Admin admin;

    private CreateAdminResponse createAdminResponse;


    @BeforeEach
    void setUp() {
//        adminService.deleteAll();
        createAdminRequest = new CreateAdminRequest();;
        createAdminRequest.setEmail("bolaji@gmail.com");
        createAdminRequest.setFirstName("Kabir");
        createAdminRequest.setLastName("Yusuf");
        createAdminRequest.setPassword("ade1236");
        createAdminRequest.setPhoneNumber("08065923833");
        createAdminResponse = adminService.createAdmin(createAdminRequest);


    }

    @AfterEach
    void afterEach(){
        adminService.deleteAll();
    }
    @Test
    void testThatAdminCanBeCreated(){
//        createAdminResponse = adminService.createAdmin(createAdminRequest);
        assertNotNull(createAdminResponse.getId());
        assertEquals("bolaji@gmail.com", createAdminResponse.getEmail());
    }
    @Test
    void testThatAdminCanBeFoundByEmail(){
//        createAdminResponse = adminService.createAdmin(createAdminRequest);
        Admin foundAdmin = adminService.findAdminByEmail("bolaji@gmail.com");
        assertEquals(createAdminResponse.getEmail(), foundAdmin.getEmail());
    }
    @Test
    void testThatAdminCanLoginUsingTheCorrectEmailAndPassWord(){
//        createAdminResponse = adminService.createAdmin(createAdminRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("ade1236");
        loginRequest.setEmail("bolaji@gmail.com");
        LoginResponse loginResponse = adminService.adminLogin(loginRequest);
        assertEquals("Login successful", loginResponse.getMessage());
    }
    @Test
    void testThatListOfAdminIsGreaterIncreasesByOneWhenANewAdminIsCreatedAndSaved(){

//        createAdminResponse = adminService.createAdmin(createAdminRequest);
        List<Admin> adminsAfterSavingFirstAdmin = adminService.getAdmins();
        assertEquals(1, adminsAfterSavingFirstAdmin.size());
        CreateAdminRequest createAdminRequest1 = new CreateAdminRequest();
        createAdminRequest1.setEmail("jaybee@gmail.com");
        createAdminRequest1.setFirstName("Kabir");
        createAdminRequest1.setLastName("Yusuf");
        createAdminRequest1.setPassword("ade1236");
        createAdminRequest1.setPhoneNumber("08065923833");

        adminService.createAdmin(createAdminRequest1);

        List<Admin> adminsAfterSavingSecondAdmin = adminService.getAdmins();
        assertEquals(2, adminsAfterSavingSecondAdmin.size());
    }
    @Test
    void testThatSizeOfAdminListDecreaseByOneWhenOneAdminIsDeleted(){
//        createAdminResponse = adminService.createAdmin(createAdminRequest);
        List<Admin> listOfAdminsAfterSavingOneAdmin = adminService.getAdmins();
        assertEquals(1, listOfAdminsAfterSavingOneAdmin.size());

        adminService.deleteAdminByEmail("bolaji@gmail.com");

        List<Admin> listOfAdminsAfterDeletingOneAdmin = adminService.getAdmins();
        assertEquals(0, listOfAdminsAfterDeletingOneAdmin.size());
    }

    @Test
    void adminCanBeUpdatedByEmail(){

        Admin foundAdminBeforeUpdate = adminService.findAdminByEmail("bolaji@gmail.com");
        assertEquals("Kabir", foundAdminBeforeUpdate.getFirstName());
        assertEquals("Yusuf", foundAdminBeforeUpdate.getLastName());

        UpdateAdminRequest updateAdminRequest = new UpdateAdminRequest();
        updateAdminRequest.setFirstName("Abdul");
        updateAdminRequest.setEmail("bolaji@gmail.com");
        adminService.updateAdminByEmail(updateAdminRequest);
        Admin foundAdminAfterUpdate = adminService.findAdminByEmail("bolaji@gmail.com");
        assertEquals("Abdul", foundAdminAfterUpdate.getFirstName());
        assertEquals("Yusuf", foundAdminAfterUpdate.getLastName());
        assertEquals("ade1236", foundAdminAfterUpdate.getPassword());
    }
    @Test
    void sizeOfBookRepositoryIncreasesWhenAdminAddsANewBookTest(){

        Book book = new Book();
        book.setBookName("Chemistry");
        book.setIsbn(1233L);
        book.setQuantity(5);
        book.setYearPublished("2022");

        CreateAuthorRequest createAuthorRequest1 = new CreateAuthorRequest();
        CreateAuthorRequest createAuthorRequest2 = new CreateAuthorRequest();
        createAuthorRequest1.setEmail("autho1@gmail.com");
        createAuthorRequest2.setEmail("autho2@gmail.com");
        authorService.createAuthor(createAuthorRequest1);
        authorService.createAuthor(createAuthorRequest2);



        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setBook(book);
        List<Long> authorIds = List.of(1L,2L);
        addBookRequest.setAuthorIds(authorIds);

        List<Book> sizeOfBookRepoBeforeAddingABook = adminService.getAllBooks();
        assertEquals(0, sizeOfBookRepoBeforeAddingABook.size());
        adminService.addBook(addBookRequest);
        List<Book> sizeOfBookRepoAfterAddingABook = adminService.getAllBooks();
        assertEquals(1, sizeOfBookRepoAfterAddingABook.size());
        Author author = authorService.getAuthorByEmail("autho1@gmail.com");
        assertEquals(1, author.getBooks().size());

//        Book foundBook = bookService.getBookByIsbn(1233L);
//        assertEquals(2, foundBook.getAuthors().size());

    }
}