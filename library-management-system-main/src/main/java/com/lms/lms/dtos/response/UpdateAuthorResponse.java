package com.lms.lms.dtos.response;

import lombok.Data;

@Data
public class UpdateAuthorResponse {
    private long id;
    private final String message = "Author updated successfully";
}
