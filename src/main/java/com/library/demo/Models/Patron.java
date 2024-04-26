package com.library.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patron_id;
    @Column(
            name = "name" ,
            nullable = false
    )
    private String name;
    @Column(
            name = "phone_number" ,
            nullable = false
    )
    private String phone_number;

    public Patron(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

}
