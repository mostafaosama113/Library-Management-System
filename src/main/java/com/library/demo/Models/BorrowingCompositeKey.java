package com.library.demo.Models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class BorrowingCompositeKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book_id;
    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron_id;


}
