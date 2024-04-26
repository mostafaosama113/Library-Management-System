package com.library.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@IdClass(BorrowingCompositeKey.class)
public class Borrowing {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book_id;

    @Id
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
