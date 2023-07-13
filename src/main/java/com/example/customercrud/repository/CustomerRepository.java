package com.example.customercrud.repository;

import com.example.customercrud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByPhone(String phone);
    boolean existsById(Integer id);
}
