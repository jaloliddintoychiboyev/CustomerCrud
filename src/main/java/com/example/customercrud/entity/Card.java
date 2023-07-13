package com.example.customercrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 16,unique = true)
    private String card_number;

    @Column(nullable = false,length = 4)
    private String password;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false,length = 80)
    private String bank_name;
}
