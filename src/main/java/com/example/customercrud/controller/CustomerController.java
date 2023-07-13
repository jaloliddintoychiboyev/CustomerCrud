package com.example.customercrud.controller;

import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.dto.CustomerDto;
import com.example.customercrud.entity.Customer;
import com.example.customercrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping()
    public List<Customer> customerList() {
        List<Customer> customers = customerService.customerList();
        return customers;
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        Customer customerBy = customerService.getCustomerBy(id);
        return customerBy;
    }

    @PostMapping
    public ApiResponse addCustomer(@RequestBody CustomerDto customerDto) {
        ApiResponse savecustomer = customerService.savecustomer(customerDto);
        return savecustomer;
    }
    @PutMapping("/{id}")
    public ApiResponse updateCustomer(@PathVariable Integer id,@RequestBody CustomerDto customerDto){
        ApiResponse response = customerService.updateCustomer(id, customerDto);
        return  response;
    }
    @DeleteMapping("/{id}")
    public ApiResponse deleteCustomer(@PathVariable Integer id){
        ApiResponse response = customerService.deleteCustomerById(id);
        return response;
    }
}
