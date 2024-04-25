package com.library.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    @Column(
            name = "title" ,
            nullable = false
    )
    private String title;
    @Column(
            name = "author" ,
            nullable = false
    )
    private String author;
    @Column(
            name = "publication_date" ,
            nullable = false
    )
    private LocalDate publication_date;
    @Column(
            name = "ISBN" ,
            nullable = false
    )
    private String ISBN;
}
