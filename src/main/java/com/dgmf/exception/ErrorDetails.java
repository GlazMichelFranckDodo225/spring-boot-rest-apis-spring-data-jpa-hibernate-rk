package com.dgmf.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Component
public class ErrorDetails {
    // Timestamp
    private LocalDateTime timestamp;
    // Error Message
    private String message;
    // Details
    private String details;
}
