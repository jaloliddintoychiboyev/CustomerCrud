package com.example.customercrud.controller;

import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.dto.CardDto;
import com.example.customercrud.dto.OrderDto;
import com.example.customercrud.entity.Card;
import com.example.customercrud.entity.Order;
import com.example.customercrud.service.CardService;
import com.example.customercrud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping
    public List<Order> orderList(){
        List<Order> orders = orderService.orderList();
        return orders;
    }
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Integer id){
        Order order = orderService.getOrder(id);
        return order;
    }
    @PostMapping
    public ApiResponse saveOrder(@RequestBody OrderDto orderDto){
        ApiResponse saveOrder = orderService.saveOrder(orderDto);
        return saveOrder;
    }
    @GetMapping("/orderPage/{page}")
    public Page<Order> orderPage(@PathVariable Integer page){
        Page<Order> orders = orderService.orderPage(page);
        return orders;
    }
    @PutMapping("/{id}")
    public ApiResponse updateOrder(@PathVariable Integer id,@RequestBody OrderDto orderDto){
        ApiResponse response = orderService.updateOrder(id, orderDto);
        return response;
    }
    @DeleteMapping("/{id}")
    public ApiResponse deleteOrder(@PathVariable Integer id){
        ApiResponse response = orderService.deleteOrderById(id);
        return response;
    }

}
