package com.example.demo.service.impl;

import com.example.demo.dto.orderItem.OrderItemDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.IOrderItemMapper;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.repository.IOrderItemRepository;
import com.example.demo.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderItemServiceImpl implements IOrderItemService {
    @Autowired
    private IOrderItemRepository orderItemRepository;

    @Autowired
    private IOrderItemMapper orderItemMapper;


    @Override
    public List<OrderItemDto> getAll() {
        return orderItemMapper.toOrderItemDTO(orderItemRepository.findAll());
    }


    @Override
    public OrderItemDto getById(int id) throws ResourceNotFoundException {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem with id " + id + " not found"));
        return orderItemMapper.toOrderItemDto(orderItem);
    }


    @Override
    public OrderItemDto post(OrderItem orderItem) {
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toOrderItemDto(savedOrderItem);
    }




    @Override
    public OrderItemDto patch(int id, OrderItem orderItem) throws ResourceNotFoundException {
        OrderItem existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem with id " + id + " not found"));
        if (orderItem.getOrder() != null) {
            existingOrderItem.setOrder(orderItem.getOrder());
        }
        if (orderItem.getProduct() != null) {
            existingOrderItem.setProduct(orderItem.getProduct());
        }

        existingOrderItem.setQuantity(orderItem.getQuantity());
        OrderItem updatedOrderItem = orderItemRepository.save(existingOrderItem);
        return orderItemMapper.toOrderItemDto(updatedOrderItem);
    }

    @Override
    public OrderItemDto delete(int id) throws ResourceNotFoundException {
        OrderItem orderItemToDelete = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem with id " + id + " not found"));
        orderItemRepository.delete(orderItemToDelete);
        return orderItemMapper.toOrderItemDto(orderItemToDelete);
    }


}