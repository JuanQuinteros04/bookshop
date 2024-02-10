package com.quinteros.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name ="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="")
    private String name;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="age")
    private Long age;

    @Column(name ="email")
    private String email;

    @OneToMany
    @JoinTable(name = "cliente_libros",
        joinColumns = @JoinColumn(name ="client_id"),
        inverseJoinColumns = @JoinColumn(name ="book_isbn"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"client_id", "book_isbn"})}
    )
    private List<Book> books;
}
