package com.example.demo.mapper;

import com.example.demo.dto.shippingMethod.ShippingMethodDto;
import com.example.demo.model.entity.ShippingMethod;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IShippingMethodMapper {
    IShippingMethodMapper INSTANCE = Mappers.getMapper(IShippingMethodMapper.class);
    ShippingMethodDto toShippingMethodDto(ShippingMethod shippingMethod);

    ShippingMethod toShippingMethod(ShippingMethodDto DTO);

    List<ShippingMethodDto> toShippingMethodsDTO(List<ShippingMethod> shippingMethod);

    List<ShippingMethod> toShippingMethods(List<ShippingMethodDto> ShippingMethodsDTO);
}