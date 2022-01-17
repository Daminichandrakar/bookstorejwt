package com.bookstore.bookstore.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String author;
    private String nameOfBook;
    private String picPath;
    private int price;
    @Column(length = 2000)
    private String description;
}