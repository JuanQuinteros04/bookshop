package com.quinteros.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class BookDTO {
    private String isbn;
    private String name;
    private String writer;
    private String editorial;

}
