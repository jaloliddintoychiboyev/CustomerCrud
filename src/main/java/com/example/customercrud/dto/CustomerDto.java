package com.example.customercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {

    private String firstname;
    private String lastname;
    private String phone;
    private Integer card_id;
    private Integer address_id;

}
