package com.library.demo.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class BorrowingController {

    @PostMapping("{bookId}/patron/{patronId}")
    public void addRecord(@PathVariable(name = "bookId") int bookId , @PathVariable(name = "patronId") int patronId){

    }
    @PutMapping("/api/return/{bookId}/patron/{patronId}")
    public void editRecord(@PathVariable(name = "bookId") int bookId , @PathVariable(name = "patronId") int patronId){

    }
}
