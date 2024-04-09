package com.example.demo.service;


import com.example.demo.dto.orderStatus.OrderStatusDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.OrderStatus;

import java.util.List;

public interface IOrderStatusService {
    List<OrderStatusDto> getAll();
    OrderStatusDto getById(Long id) throws ResourceNotFoundException;

    OrderStatusDto post(OrderStatus orderStatus);

    OrderStatusDto patch(Long id,OrderStatus orderStatus) throws ResourceNotFoundException;

    OrderStatusDto delete(Long id) throws ResourceNotFoundException;


}