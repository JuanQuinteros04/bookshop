package com.quinteros.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String isbn;
    private String name;
    private String writer;
    private String editorial;

}
