package com.quinteros.service;

import com.quinteros.model.Book;
import com.quinteros.model.dto.BookDTO;
import com.quinteros.model.dto.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> findAll();

    BookResponse findBookById(Long id);

    BookResponse createBook(BookDTO bookDTO);

    void updateBook(Long id, BookDTO bookDTO);

    void deleteBook(Long id);

}
