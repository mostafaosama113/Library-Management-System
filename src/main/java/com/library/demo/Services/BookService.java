package com.library.demo.Services;

import com.library.demo.Models.Book;
import com.library.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Book> editBook(Long id , Book newBook){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return Optional.empty();
        }
        if(newBook.getAuthor() != null){
            book.get().setAuthor(newBook.getAuthor());
        }
        if(newBook.getTitle() != null){
            book.get().setTitle(newBook.getTitle());
        }
        if(newBook.getIsbn() != null){
            book.get().setIsbn(newBook.getIsbn());
        }
        if(newBook.getPublication_date() != null){
            book.get().setPublication_date(newBook.getPublication_date());
        }
        bookRepository.save(book.get());
        return Optional.of(book.get());
    }
}
