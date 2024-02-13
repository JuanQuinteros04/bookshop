package com.quinteros.model.mapper;

import com.quinteros.model.Book;
import com.quinteros.model.dto.BookDTO;
import com.quinteros.model.dto.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;



@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", ignore = true)
    Book bookDTOToBook(BookDTO bookDTO);

    BookResponse bookToBookResponse(Book book);

}
