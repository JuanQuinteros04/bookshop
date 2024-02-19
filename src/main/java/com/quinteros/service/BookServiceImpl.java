package com.quinteros.service;

import com.quinteros.exceptions.NotFoundException;
import com.quinteros.model.Book;
import com.quinteros.model.dto.BookDTO;
import com.quinteros.model.dto.BookResponse;
import com.quinteros.model.mapper.BookMapper;
import com.quinteros.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    BookMapper bookMapper = BookMapper.INSTANCE;

    @Override
    public List<BookResponse> findAll() {
        return bookRepository.findAll().stream().map(book -> bookMapper.bookToBookResponse(book)).collect(Collectors.toList());
    }

    @Override
    public BookResponse findBookById(Long id) {
        return bookMapper.bookToBookResponse(bookRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public BookResponse createBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        bookRepository.save(book);
        return bookMapper.bookToBookResponse(book);
    }

    @Override
    public void updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);

        // Actualizar los campos del libro si se proporcionan en el DTO
        book.setName(bookDTO.getName() != null ? bookDTO.getName() : book.getName());
        book.setIsbn(bookDTO.getIsbn() != null ? Long.valueOf(bookDTO.getIsbn()) : book.getIsbn());
        book.setWriter(bookDTO.getWriter() != null ? bookDTO.getWriter() : book.getWriter());
        book.setEditorial(bookDTO.getEditorial() != null ? bookDTO.getEditorial() : book.getEditorial());

        // Guardar el libro actualizado en la base de datos
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {

        bookRepository.delete(bookRepository.findById(id).orElseThrow(NotFoundException::new));

    }
}
