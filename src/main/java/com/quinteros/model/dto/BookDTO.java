package com.quinteros.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDTO {
    private String isbn;
    private String name;
    private String writer;
    private String editorial;

}
