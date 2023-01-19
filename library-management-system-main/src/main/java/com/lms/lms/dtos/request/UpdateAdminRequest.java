package com.lms.lms.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data

public class UpdateAdminRequest {
    private Long id;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
}
