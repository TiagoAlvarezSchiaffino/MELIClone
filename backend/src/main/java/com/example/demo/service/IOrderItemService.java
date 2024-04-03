package com.example.demo.repository.product_repository;

import com.example.demo.dto.orderItem.OrderItemDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.OrderItem;

import java.util.List;

public interface IOrderItemService {
    List<OrderItemDto> getAll();
    OrderItemDto getById(int id) throws ResourceNotFoundException;

    OrderItemDto post(OrderItem orderItem);

    OrderItemDto patch(int id,OrderItem orderItem) throws ResourceNotFoundException;

    OrderItemDto delete(int id) throws ResourceNotFoundException;

}