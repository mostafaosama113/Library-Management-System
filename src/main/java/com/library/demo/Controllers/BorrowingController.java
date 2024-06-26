package com.library.demo.Controllers;

import com.library.demo.Services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
public class BorrowingController {


    private final BorrowingService borrowingService;
    @Autowired
    BorrowingController(BorrowingService borrowingService){
        this.borrowingService = borrowingService;
    }
    @PostMapping("borrow/{bookId}/patron/{patronId}")
    public ResponseEntity addRecord(@PathVariable(name = "bookId") Long bookId , @PathVariable(name = "patronId") Long patronId){
        Optional<String> message = borrowingService.addRecord(bookId , patronId);
        if(message.isPresent()){
            Map<String , String> response = new HashMap<>();
            response.put("message" , message.get());
            return new ResponseEntity(response , HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("Book has been borrowed.");
        }
    }
    @PutMapping("return/{bookId}/patron/{patronId}")
    public ResponseEntity editRecord(@PathVariable(name = "bookId") Long bookId , @PathVariable(name = "patronId") Long patronId){
        Optional<String> message = borrowingService.returnBook(bookId , patronId);
        if(message.isPresent()){
            Map<String , String> response = new HashMap<>();
            response.put("message" , message.get());
            return new ResponseEntity(response , HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("Book has been returned.");
        }
    }
}
