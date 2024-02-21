package com.quinteros.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {
    private String name;

    private String lastName;

    private Long age;

    private String email;

}
