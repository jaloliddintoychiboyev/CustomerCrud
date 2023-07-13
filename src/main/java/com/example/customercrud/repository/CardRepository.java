package com.example.customercrud.repository;

import com.example.customercrud.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
    boolean existsById(Integer id);
}
