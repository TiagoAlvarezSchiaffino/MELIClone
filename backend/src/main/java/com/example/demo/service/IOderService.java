package com.example.demo.service;

import com.example.demo.dto.order.OrderDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.Order;

import java.util.Date;
import java.util.List;

public interface IOrderService {
    List<OrderDto> getAll();
    OrderDto getById(int id) throws ResourceNotFoundException;

    OrderDto post(Order order);

    OrderDto patch(int id,Order order) throws ResourceNotFoundException;

    OrderDto delete(int id) throws ResourceNotFoundException;

    List<OrderDto> getByUser(int id);

}