package com.lms.lms.dtos.response;

import lombok.Data;

@Data
public class UpdateAdminResponse {
    private final String message = "updated successfully";
    private Long id;
}
