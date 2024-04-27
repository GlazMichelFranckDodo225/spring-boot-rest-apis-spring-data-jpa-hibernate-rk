package com.dgmf.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class HelloWorldBean {
    private String message;
}
