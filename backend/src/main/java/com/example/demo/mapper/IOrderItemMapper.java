package com.example.demo.mapper;

import com.example.demo.dto.orderItem.OrderItemDto;
import com.example.demo.model.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


    @Mapper(componentModel = "spring", uses = { }, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public interface IOrderItemMapper {
        IOrderItemMapper INSTANCE = Mappers.getMapper(IOrderItemMapper.class);
        OrderItemDto toOrderItemDto(OrderItem orderItem);

        OrderItem toOrderItem(OrderItemDto DTO);

        List<OrderItemDto> toOrderItemsDTO(List<OrderItem> orderItems);

        List<OrderItem> toOrderItems(List<OrderItemDto> orderItemsDTO);

}