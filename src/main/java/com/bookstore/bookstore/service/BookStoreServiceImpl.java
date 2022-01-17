package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.BookDto;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;

@Service
@PropertySource("classpath:message.properties")
public class BookStoreServiceImpl implements IBookStoreService{

    @Autowired
    BookStoreRepository bookStoreRepository;

    @Autowired
    private Environment environment;

    @Override
    public String loadBookData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/books_data.csv"));
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Book book = new Book();
                book.setAuthor(data[1].replaceAll("'", ""));
                book.setNameOfBook(data[2].replaceAll("'", ""));
                book.setQuantity(Integer.parseInt(data[3].replaceAll("'", "")));
                book.setPicPath(data[4].replaceAll("'", ""));
                book.setPrice(Integer.parseInt(data[5].replaceAll("'", "")));
                IntStream.range(7, data.length - 1).forEach(column -> data[6] += "," + data[column]);
                book.setDescription(data[6]);
                bookStoreRepository.save(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return environment.getProperty("CSV_FILE_LOADED");
    }

//    @Override
//    public Page<Book> getAllBook(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public Page<Book> findByAuthor(String author, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public Page<Book> getAllBookByPriceAsc(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public Page<Book> getAllBookByPriceDesc(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public String fetchBookData(MultipartFile multipartFile) {
//        return null;
//    }
//
//    @Override
//    public String addNewBook(BookDto bookDto) {
//        return null;
//    }
}
