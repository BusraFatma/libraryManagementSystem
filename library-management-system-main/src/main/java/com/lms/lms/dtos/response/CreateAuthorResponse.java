package com.lms.lms.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CreateAuthorResponse {
    @JsonIgnore
    private Long id;
    private final String message = "Successful";
//    private String message;
}
