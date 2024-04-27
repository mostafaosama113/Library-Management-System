package com.library.demo.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor

public class Borrowing{
    @EmbeddedId
    private BorrowingCompositeKey id;

    @Column(
            name = "borrowing_date"
    )
    @NotBlank
    private LocalDate borrowing_date;

    @Column(
            name = "return_date"
    )
    private LocalDate return_date;
}
