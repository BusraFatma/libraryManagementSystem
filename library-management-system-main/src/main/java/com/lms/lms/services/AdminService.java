package com.lms.lms.services;

import com.lms.lms.data.models.Admin;
import com.lms.lms.data.models.Book;
import com.lms.lms.dtos.request.AddBookRequest;
import com.lms.lms.dtos.request.CreateAdminRequest;
import com.lms.lms.dtos.request.LoginRequest;
import com.lms.lms.dtos.request.UpdateAdminRequest;
import com.lms.lms.dtos.response.AddBookResponse;
import com.lms.lms.dtos.response.CreateAdminResponse;
import com.lms.lms.dtos.response.LoginResponse;
import com.lms.lms.dtos.response.UpdateAdminResponse;

import java.util.List;

public interface AdminService {
    CreateAdminResponse createAdmin(CreateAdminRequest createAdminRequest);
    Admin findAdminById(Long id);

    Admin findAdminByEmail(String email);

    LoginResponse adminLogin(LoginRequest loginRequest);

    List<Admin> getAdmins();
    String deleteAdminById(Long id);

    String deleteAdminByEmail(String email);

    void deleteAll();

    UpdateAdminResponse updateAdminById(UpdateAdminRequest updateAdminRequest);
    UpdateAdminResponse updateAdminByEmail(UpdateAdminRequest updateAdminRequest);

    AddBookResponse addBook(AddBookRequest addBookRequest);

    List<Book> getAllBooks();
}
