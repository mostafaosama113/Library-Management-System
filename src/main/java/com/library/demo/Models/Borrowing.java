package com.library.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Borrowing{
    @EmbeddedId
    private BorrowingCompositeKey id;

    @Column(
            name = "borrowing_date",
            nullable = false
    )
    private LocalDate borrowing_date;

    @Column(
            name = "return_date"
    )
    private LocalDate return_date;
}
