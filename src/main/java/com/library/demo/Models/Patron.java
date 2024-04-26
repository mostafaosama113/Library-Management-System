package com.library.demo.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Entity
@Data
@NoArgsConstructor

public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patron_id;
    @Column(
            name = "name"
    )
    @NotNull
    private String name;
    @Column(
            name = "phone_number"
    )
    @NotNull
    private String phone_number;

    public Patron(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

}
