package com.lms.lms.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateAdminResponse {
    @JsonIgnore
    private Long id;
    private String email;
    private final String message = "Successful";
}
