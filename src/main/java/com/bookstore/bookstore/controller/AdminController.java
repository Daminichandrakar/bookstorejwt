package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.BookDto;
import com.bookstore.bookstore.service.IBookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/home/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private IBookStoreService iBookStoreService;

    @GetMapping("/loadcsv")
    public String loadCSVData(@RequestHeader String Authorization) {
        iBookStoreService.loadBookData();
        return "CSV loaded successfully";
    }

//    @PostMapping("/addbook")
//    public ResponseEntity addNewBook(@RequestBody BookDto bookDto, @RequestHeader String Authorization) {
//        return new ResponseEntity(iBookStoreService.addNewBook(bookDto), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/uploadcsv")
//    public ResponseEntity<String> uploadCsvData(@RequestParam("multipartFile") MultipartFile multipartFile, @RequestHeader String Authorization) {
//        return new ResponseEntity(iBookStoreService.fetchBookData(multipartFile), HttpStatus.ACCEPTED);
//    }
}

