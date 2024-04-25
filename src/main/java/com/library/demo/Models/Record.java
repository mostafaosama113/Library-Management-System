package com.library.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long record_id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id")
    private Patron patron_id;

    @Column(
            name = "borrowing_date" ,
            nullable = false
    )
    private LocalDate borrowing_date;

    @Column(
            name = "return_date" ,
            nullable = false
    )
    private LocalDate return_date;
}
