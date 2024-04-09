package com.example.demo.service.impl;

import com.example.demo.dto.order.OrderDetailPostDto;
import com.example.demo.dto.order.OrderListGetDto;
import com.example.demo.dto.order.OrderPostDto;
import com.example.demo.dto.order.OrderUpdatePostDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.IOrderMapper;
import com.example.demo.model.entity.Order;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class OrderServiceImpl implements IOrderService {
    @Autowired
    private final IOrderRepository orderRepository;

    @Autowired
    private final IOrderMapper orderMapper;


    @Override
    public List<OrderListGetDto> getAll() {
        return orderMapper.toOrderListGetDtos(orderRepository.findAll());
    }

    @Override
    public OrderListGetDto getById(Long id) throws ResourceNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " not found"));
        return orderMapper.toOrderListGetDto(order);


    }

    @Override
    public OrderPostDto post(OrderPostDto orderPostDto) {
        Order savedOrder =   this.orderRepository.save(this.orderMapper.toOrder(orderPostDto));

        return orderMapper.toOrderDto(savedOrder);

    }


    @Override
    public OrderListGetDto patch(Long id, OrderUpdatePostDto orderUpdatePostDto) throws ResourceNotFoundException {
        /*Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " not found"));
        existingOrder.setDate(order.getDate());
        existingOrder.setOrderStatus(order.getOrderStatus());
        existingOrder.setOrderTotal(order.getOrderTotal());
        existingOrder.setUser(order.getUser());
        existingOrder.setShippingMethod(order.getShippingMethod());
        existingOrder.setShippingAddress(order.getShippingAddress());

        Order updatedOrder = orderRepository.save(existingOrder);
//     return orderMapper.toOrderDto(updatedOrder);

        return orderMapper.toOrderDetailPostDto(updatedOrder);
    */

        this.orderRepository.findById(id).ifPresent(
                order -> {
                    this.orderMapper.updateOrder(orderUpdatePostDto, order);
                    this.orderRepository.save(order);
                }
        );
        return this.getById(id);
    }


    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Order orderToDelete = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " not found"));
        orderRepository.delete(orderToDelete);

    }

    @Override
    public List<OrderListGetDto> getByUser(Long id) {
        return orderMapper.toOrderListGetDtos(orderRepository.findByUser_id(id));

    }


}