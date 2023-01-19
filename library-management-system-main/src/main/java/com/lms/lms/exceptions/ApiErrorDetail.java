package com.lms.lms.exceptions;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ApiErrorDetail {
    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public ApiErrorDetail(String message, String details) {
        this.message = message;
        this.details = details;
        this.timeStamp = LocalDateTime.now();
    }
}
