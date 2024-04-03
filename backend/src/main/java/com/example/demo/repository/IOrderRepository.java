package com.example.demo.repository;

import com.example.demo.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser_id(int id);
}