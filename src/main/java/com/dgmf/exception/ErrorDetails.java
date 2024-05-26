package com.dgmf.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ErrorDetails {
    // Timestamp
    private LocalDate timestamp;
    // Error Message
    private String message;
    // Details
    private String details;
}
