package com.example.customercrud.repository;

import com.example.customercrud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    boolean existsById(Integer id);
}
