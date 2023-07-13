package com.example.customercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardDto {

    private String card_number;
    private String password;
    private Double balance;
    private String bank_name;

}
