package com.example.demo.service;

import com.example.demo.dto.order.OrderDetailPostDto;
import com.example.demo.dto.order.OrderListGetDto;
import com.example.demo.dto.order.OrderPostDto;
import com.example.demo.dto.order.OrderUpdatePostDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.Order;

import java.util.List;

public interface IOrderService {
    List<OrderListGetDto> getAll();
    OrderListGetDto getById(Long id) throws ResourceNotFoundException;

    OrderPostDto post(OrderPostDto orderPostDto);

    OrderListGetDto patch(Long id, OrderUpdatePostDto orderUpdatePostDto) throws ResourceNotFoundException;

    void delete(Long id) throws ResourceNotFoundException;


    List<OrderListGetDto> getByUser(Long id);

}