package com.dgmf.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
// @JsonIgnoreProperties(value = {"field1", "field2"})
// @JsonIgnoreProperties({"field1", "field2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;
    // @JsonIgnore
    private String field2;
    private String field3;
}
