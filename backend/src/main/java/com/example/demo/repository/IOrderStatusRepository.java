package com.example.demo.repository;

import com.example.demo.model.entity.OrderStatus;
import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderStatusRepository  extends JpaRepository<OrderStatus, Long> {
}