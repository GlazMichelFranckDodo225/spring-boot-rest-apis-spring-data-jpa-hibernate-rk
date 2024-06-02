package com.dgmf.entity;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    private Long id;
    @Size(min = 2, message = "Name Should Have at Least 2 Characters")
    private String name;
    @Past(message = "Birth Date Should Be in the Past")
    private LocalDate birthDate;
}
