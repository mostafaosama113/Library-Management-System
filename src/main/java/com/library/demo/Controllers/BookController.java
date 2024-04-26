package com.library.demo.Controllers;

import com.library.demo.Models.Book;
import com.library.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    @Autowired
    BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks() , HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Book> getAllBooks(@PathVariable Long id){
        Optional<Book> book = bookService.getBookById(id);
        if(book.isPresent()){
            return new ResponseEntity<>(book.get() , HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        boolean result = bookService.addBook(book);
        if(result){
            return new ResponseEntity<>(book , HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Book> addBook(@PathVariable(name = "id") Long id){
        Optional<Book> result = bookService.deleteBook(id);
        if(result.isPresent()){
            return new ResponseEntity<>(result.get() , HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<Book> editBook(@PathVariable(name = "id") Long id , @RequestBody Book book){
        Optional<Book> result = bookService.editBook(id , book);
        if(result.isPresent()){
            return new ResponseEntity<>(result.get() , HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
