package com.example.customercrud.service;

import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.dto.CustomerDto;
import com.example.customercrud.entity.Address;
import com.example.customercrud.entity.Card;
import com.example.customercrud.entity.Customer;
import com.example.customercrud.repository.AddressRepository;
import com.example.customercrud.repository.CardRepository;
import com.example.customercrud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CardRepository cardRepository;
    public List<Customer> customerList(){
        List<Customer> all = customerRepository.findAll();
        return all;
    }
    public Customer getCustomerBy(Integer id){
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }
    public ApiResponse savecustomer(CustomerDto customerDto){
//        boolean existsByPhone=customerRepository.existsByPhone(customerDto.getPhone());
//        if (existsByPhone){
//            return new ApiResponse("Error! Please tyr Again or change the Informs!",false);
//        }
        Customer customer=new Customer();
        List<Card> cardList=new ArrayList<>();
        Address address = addressRepository.findById(customerDto.getAddress_id()).get();
        Card card = cardRepository.findById(customerDto.getCard_id()).get();
        cardList.add(card);
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(address);
        customer.setCard(cardList);
        customerRepository.save(customer);
        return new ApiResponse("Successful!!",true);
    }
    public ApiResponse updateCustomer(Integer id,CustomerDto customerDto){
        boolean b = customerRepository.existsById(id);
        if (b){
            Customer customer = customerRepository.findById(id).get();
            Address address1 = addressRepository.findById(customerDto.getAddress_id()).get();
            Card card1 = cardRepository.findById(customerDto.getCard_id()).get();
            Address address=new Address();
            Card card=new Card();
            address.setCity(address1.getCity());
            address.setDistrict(address1.getDistrict());
            address.setStreet(address1.getStreet());
            address.setHome_number(address1.getHome_number());
            card.setCard_number(card1.getCard_number());
            card.setBalance(card1.getBalance());
            card.setPassword(card1.getPassword());
            card.setBank_name(card1.getBank_name());
            customer.setPhone(customerDto.getPhone());
            customer.setLastname(customerDto.getLastname());
            customer.setFirstname(customerDto.getFirstname());
            customer.setAddress(address);
            customer.setCard((List<Card>) card);
            customerRepository.save(customer);
            ApiResponse response=new ApiResponse("Successfull Update Customer!",true);
            return  response;
        }else {
            ApiResponse response=new ApiResponse("Id not Found!",false);
            return  response;
        }
    }
    public  ApiResponse deleteCustomerById(Integer id){
        boolean b = customerRepository.existsById(id);
        if (b){
            customerRepository.deleteById(id);
            ApiResponse response=new ApiResponse("Successful Delete Customer!",true);
            return  response;
        }else {
            ApiResponse response=new ApiResponse("Id Not Found!",false);
            return  response;
        }

    }

}
