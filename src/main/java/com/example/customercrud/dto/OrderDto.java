package com.example.customercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    private Integer product_id;
    private Integer customer_id;
    private Integer count_product;

}
