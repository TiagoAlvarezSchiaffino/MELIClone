package com.example.demo.service;


import com.example.demo.dto.orderStatus.OrderStatusDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.OrderStatus;

import java.util.List;

public interface IOrderStatusService {
    List<OrderStatusDto> getAll();
    OrderStatusDto getById(int id) throws ResourceNotFoundException;

    OrderStatusDto post(OrderStatus orderStatus);

    OrderStatusDto patch(int id,OrderStatus orderStatus) throws ResourceNotFoundException;

    OrderStatusDto delete(int id) throws ResourceNotFoundException;


}