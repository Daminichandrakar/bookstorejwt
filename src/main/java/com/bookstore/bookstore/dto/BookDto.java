package com.bookstore.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String author;
    private String nameOfBook;
    private String picPath;
    private int price;
    private String description;
}
