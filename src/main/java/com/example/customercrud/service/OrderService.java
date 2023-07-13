package com.example.customercrud.service;

import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.dto.CardDto;
import com.example.customercrud.dto.OrderDto;
import com.example.customercrud.entity.Card;
import com.example.customercrud.entity.Customer;
import com.example.customercrud.entity.Order;
import com.example.customercrud.entity.Product;
import com.example.customercrud.repository.CardRepository;
import com.example.customercrud.repository.CustomerRepository;
import com.example.customercrud.repository.OrderRepository;
import com.example.customercrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;

    public List<Order> orderList() {
        List<Order> all = orderRepository.findAll();
        return all;
    }

    public Page<Order> orderPage(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Order> all = orderRepository.findAll(pageable);
        return all;
    }

    public Order getOrder(Integer id) {
        Order order = orderRepository.findById(id).get();
        return order;
    }

    public ApiResponse saveOrder(OrderDto orderDto) {
        Order order = new Order();
        Product product = productRepository.findById(orderDto.getProduct_id()).get();
        Customer customer = customerRepository.findById(orderDto.getCustomer_id()).get();
        order.setCount_product(orderDto.getCount_product());
        order.setCustomer(customer);
        order.setProduct(product);
        orderRepository.save(order);
        ApiResponse apiResponse = new ApiResponse("Successful Saved Order", true);
        return apiResponse;
    }

    public ApiResponse updateOrder(Integer id, OrderDto orderDto) {
        boolean b = orderRepository.existsById(id);
        if (b) {
            Customer customer = customerRepository.findById(orderDto.getCustomer_id()).get();
            Product product = productRepository.findById(orderDto.getCount_product()).get();
            Order order = orderRepository.findById(id).get();
            order.setCount_product(orderDto.getCount_product());
            order.setCustomer(customer);
            order.setProduct(product);
            orderRepository.save(order);
            ApiResponse response = new ApiResponse("Successful Update Order", true);
            return response;
        } else {
            ApiResponse response = new ApiResponse("Id Not Found!", false);
            return response;
        }
    }

    public ApiResponse deleteOrderById(Integer id) {
        boolean b = orderRepository.existsById(id);
        if (b) {
            orderRepository.deleteById(id);
            ApiResponse response = new ApiResponse("Successful Delete Order!", true);
            return response;
        } else {
            ApiResponse response = new ApiResponse("Id Not found!", false);
            return response;
        }
    }
}
