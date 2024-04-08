package com.example.demo.mapper;

import com.example.demo.dto.orderStatus.OrderStatusDto;
import com.example.demo.model.entity.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

    @Mapper(componentModel = "spring", uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public interface IOrderStatusMapper {
        IOrderStatusMapper INSTANCE = Mappers.getMapper(IOrderStatusMapper.class);
        OrderStatusDto toOrderStatusDto(OrderStatus orderStatus);

        OrderStatus toOrderStatus(OrderStatusDto DTO);

        List<OrderStatusDto> toOrderStatusDTO(List<OrderStatus> orderStatus);

        List<OrderStatus> toOrderStatus(List<OrderStatusDto> orderStatusDTO);
    }