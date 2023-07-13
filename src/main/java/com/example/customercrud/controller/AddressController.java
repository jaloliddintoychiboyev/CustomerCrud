package com.example.customercrud.controller;

import com.example.customercrud.dto.AddressDto;
import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.entity.Address;
import com.example.customercrud.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping
    public List<Address> addressList(){
        List<Address> addressList = addressService.addressList();
        return addressList;
    }
    @GetMapping("/{id}")
    public Address address(@PathVariable Integer id){
        Address address = addressService.getAddress(id);
        return address;
    }
    @PostMapping
    public ApiResponse saveAddress(@RequestBody AddressDto addressDto){
        ApiResponse savecard = addressService.saveAddress(addressDto);
        return savecard;
    }
    @GetMapping("/addressPage/{page}")
    public Page<Address> addressPage(@PathVariable Integer page){
        Page<Address> addressPage = addressService.addressPage(page);
        return addressPage;
    }
    @PutMapping("/{id}")
    public ApiResponse updateAddress(@PathVariable Integer id,@RequestBody AddressDto addressDto){
        ApiResponse response = addressService.updateAddress(id, addressDto);
        return response;
    }
    @DeleteMapping("/{id}")
    public ApiResponse deleteaddress(@PathVariable Integer id){
        ApiResponse response = addressService.deleteAddress(id);
        return response;
    }

}
