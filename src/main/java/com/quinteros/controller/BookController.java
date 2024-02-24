package com.quinteros.controller;

import com.quinteros.model.dto.BookDTO;
import com.quinteros.model.dto.BookResponse;
import com.quinteros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookResponse>> findAll(){
      return ResponseEntity.ok(bookService.findAll());
    };

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> findBookById(@PathVariable("id")Long id){
      return ResponseEntity.ok(bookService.findBookById(id));
    };

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> createBook(BookDTO bookDTO){
        return ResponseEntity.ok(bookService.createBook(bookDTO));
    }

    @PostMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBook(@PathVariable("id") Long id,BookDTO bookDTO){
        bookService.updateBook(id, bookDTO);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return ResponseEntity.status(204).build();
    }

}
