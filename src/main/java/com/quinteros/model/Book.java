package com.quinteros.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="isbn", unique = true)
    private Long isbn;

    @Column(name ="name")
    private String name;

    @Column(name ="name")
    private String writer;

    @Column(name ="editorial")
    private String editorial;

}
