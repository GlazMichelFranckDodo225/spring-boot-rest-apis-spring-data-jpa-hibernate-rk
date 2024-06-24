package com.dgmf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity(name = "post_details")
public class Post {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String shortDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
