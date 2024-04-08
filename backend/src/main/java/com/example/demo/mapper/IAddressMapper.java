package com.example.demo.mapper;


import com.example.demo.dto.address.*;
import com.example.demo.model.entity.Address;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IAddressMapper {

    @Mappings({
            @Mapping(target = "provinceId", source = "provinceFk"),
            @Mapping(target = "userId", source = "userFk")
    }
    )
    AddressPostDto toAddressDto(Address address);


    AddressDetailPostDto toAddressDetailPostDto(Address address);


    @Mappings({

            @Mapping(target = "userId", source = "userFk")
    }
    )
    AddressPostResponseDto tAddressPostResponseDto(Address address);

    List<AddressListGetDto> toAddressListGetDtos(List<Address> addresses);


    AddressListGetDto toAddressListGetDto(Address address);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "province", ignore = true),
            @Mapping(target = "provinceFk", source = "provinceId"),
            @Mapping(target = "userFk", ignore = true)
    }
    )
    void updateAddress(AddressUpdatePostDto addressUpdatePostDto, @MappingTarget Address address);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "province", ignore = true),
            @Mapping(target = "provinceFk", source = "provinceId"),
            @Mapping(target = "userFk", source = "userId")
    }
    )
    Address toAddress(AddressPostDto addressPostDto);

}