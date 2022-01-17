package com.bookstore.bookstore.utility;

import com.bookstore.bookstore.dto.BookDto;
import com.bookstore.bookstore.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterService {
    @Autowired
    private ModelMapper modelMapper;

    public BookDto convertToBookDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    public Book convertToBookEntity(BookDto bookDto) {
        return modelMapper.map(bookDto, Book.class);
    }

}
