package com.library.demo.Services;

import com.library.demo.Models.Book;
import com.library.demo.Repositories.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    private Book book1;
    private Book book2;

    @BeforeEach
    public void setup() {
        bookRepository.deleteAll();
        book1 = new Book( "Title 1", "Author 1", LocalDate.of(2023, 2, 1), "1234567890");
        book2 = new Book( "Title 2", "Author 2", LocalDate.of(2022, 2, 2), "9876543210");
        bookRepository.save(book1);
        bookRepository.save(book2);
    }

    @AfterEach
    public void teardown() {
        bookRepository.deleteAll();
    }

    @Test
    public void editBook_Success() {
        Book updatedBook = new Book( "Updated Title 1", "Updated Author 1", LocalDate.of(2023, 2, 1), "1234567890");
        Optional<Book> updatedBookOptional = bookService.editBook(book1.getBook_id(), updatedBook);
        // System.out.println(book1.getBook_id());
        // assertTrue(updatedBookOptional.isPresent());
        Book updatedBookFromDB = updatedBookOptional.get();

        assertEquals(updatedBook.getTitle(), updatedBookFromDB.getTitle());
        assertEquals(updatedBook.getAuthor(), updatedBookFromDB.getAuthor());
        assertEquals(updatedBook.getIsbn(), updatedBookFromDB.getIsbn());
        assertEquals(updatedBook.getPublication_date(), updatedBookFromDB.getPublication_date());
    }

    @Test
    public void editBook_InvalidBookId_Failure() {
        Book updatedBook = new Book( "Updated Title 1", "Updated Author 1", LocalDate.of(2023, 2, 1), "1234567890");
        Optional<Book> updatedBookOptional = bookService.editBook(999999999L, updatedBook);
        assertFalse(updatedBookOptional.isPresent());
    }

    @Test
    public void editBook_NullBook_Failure() {
        Optional<Book> updatedBookOptional = bookService.editBook(book1.getBook_id(), null);
        assertFalse(updatedBookOptional.isPresent());
    }

    @Test
    public void editBook_NullBookId_Failure() {
        Book updatedBook = new Book("Updated Title 1", "Updated Author 1", LocalDate.of(2023, 2, 1), "1234567890");
        Optional<Book> updatedBookOptional = bookService.editBook(null, updatedBook);
        assertFalse(updatedBookOptional.isPresent());
    }


}
