package com.example.demo.service;

import com.example.demo.dto.orderItem.OrderItemDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.OrderItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderItemService {
    List<OrderItemDto> getAll();
    OrderItemDto getById(int id) throws ResourceNotFoundException;

    OrderItemDto post(OrderItem orderItem) throws ResourceNotFoundException;

    OrderItemDto patch(int id,OrderItem orderItem) throws ResourceNotFoundException;

    OrderItemDto delete(int id) throws ResourceNotFoundException;
    /*List<OrderItemDto>getItemsByOrder(int id);
    List<OrderItemDto>getItemsByProduct(int id);
*/
}