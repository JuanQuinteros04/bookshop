package com.quinteros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
