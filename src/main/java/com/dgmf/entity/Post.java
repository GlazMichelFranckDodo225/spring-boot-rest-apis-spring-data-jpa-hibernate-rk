package com.dgmf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity(name = "post_details")
public class Post {
    @Id @GeneratedValue
    private Long id;
    @Size(min = 2, message = "Name Should Have at Least 2 Characters")
    private String title;
    @Size(min = 10, message = "Short Description Should Have at Least 10 Characters")
    private String shortDescription;
    // @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JsonIgnore
    private User user;
}
