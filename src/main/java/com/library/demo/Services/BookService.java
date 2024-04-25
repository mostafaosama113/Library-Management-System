package com.library.demo.Services;

import com.library.demo.Models.Book;
import com.library.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public boolean addBook(Book book){

        bookRepository.save(book);
        return true;
    }
    public Optional<Book> deleteBook(Long id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return Optional.empty();
        }
        bookRepository.deleteById(id);
        return Optional.of(book.get());
    }
    public Optional<Book> editBook(Long id , Book new_book){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return Optional.empty();
        }
        if(new_book.getAuthor() != null){
            book.get().setAuthor(new_book.getAuthor());
        }
        if(new_book.getTitle() != null){
            book.get().setTitle(new_book.getTitle());
        }
        if(new_book.getIsbn() != null){
            book.get().setIsbn(new_book.getIsbn());
        }
        if(new_book.getPublication_date() != null){
            book.get().setPublication_date(new_book.getPublication_date());
        }
        bookRepository.save(book.get());
        return Optional.of(book.get());
    }
}
