package com.example.customercrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_of_customer")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Product product;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Customer customer;

    @Column(nullable = false)
    private Integer count_product;
}
