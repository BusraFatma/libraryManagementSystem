package com.lms.lms.dtos.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.Instant;
@Data
public class CreateAdminRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
}
