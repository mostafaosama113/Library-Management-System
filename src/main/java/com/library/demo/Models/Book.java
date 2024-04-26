package com.library.demo.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    @Column(
            name = "title"
    )
    @NotNull
    private String title;
    @Column(
            name = "author"
    )
    @NotNull
    private String author;
    @Column(
            name = "publication_date"
    )
    @NotNull
    private LocalDate publication_date;
    @Column(
            name = "isbn"
    )
    @NotNull
    private String isbn;

    public Book(String title, String author, LocalDate publication_date, String ISBN) {
        this.title = title;
        this.author = author;
        this.publication_date = publication_date;
        this.isbn = isbn;
    }
}
