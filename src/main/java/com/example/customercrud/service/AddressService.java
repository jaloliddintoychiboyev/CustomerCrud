package com.example.customercrud.service;

import com.example.customercrud.dto.AddressDto;
import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.entity.Address;
import com.example.customercrud.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public List<Address> addressList() {
        List<Address> all = addressRepository.findAll();
        return all;
    }

    public Page<Address> addressPage(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Address> all = addressRepository.findAll(pageable);
        return all;
    }

    public Address getAddress(Integer id) {
        Address address = addressRepository.findById(id).get();
        return address;
    }

    public ApiResponse saveAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setDistrict(addressDto.getDistrict());
        address.setStreet(addressDto.getStreet());
        address.setHome_number(addressDto.getHome_number());
        addressRepository.save(address);
        ApiResponse apiResponse = new ApiResponse("Successful Saved Address", true);
        return apiResponse;
    }

    public ApiResponse updateAddress(Integer id, AddressDto addressDto) {
        boolean b = addressRepository.existsById(id);
        if (b) {
            Address address = addressRepository.findById(id).get();
            address.setCity(addressDto.getCity());
            address.setDistrict(addressDto.getDistrict());
            address.setStreet(addressDto.getStreet());
            address.setHome_number(addressDto.getHome_number());
            addressRepository.save(address);
            ApiResponse response = new ApiResponse("Successful Update Address", true);
            return response;
        } else {
            ApiResponse response = new ApiResponse("Id Not Found!", false);
            return response;
        }
    }

    public ApiResponse deleteAddress(Integer id) {
        boolean b = addressRepository.existsById(id);
        if (b) {
            addressRepository.deleteById(id);
            ApiResponse response = new ApiResponse("Successful Delete Address!", true);
            return response;
        } else {
            ApiResponse response = new ApiResponse("Id Not found!", false);
            return response;
        }
    }


}
