package com.dgmf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity(name = "user_details")
public class User {
    @Id @GeneratedValue
    private Long id;
    @Size(min = 2, message = "Name Should Have at Least 2 Characters")
    private String name;
    @Past(message = "Birth Date Should Be in the Past")
    private LocalDate birthDate;
}
