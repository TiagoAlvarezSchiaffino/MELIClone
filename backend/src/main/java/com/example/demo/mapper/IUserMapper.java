package com.example.demo.mapper;

import com.example.demo.dto.order.OrderDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserRegisterDto;
import com.example.demo.dto.user.UserTokenDto;
import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IUserMapper {


    UserDto toUserDto(User user);

    
    @Mapping(target = "token", ignore = true)
    UserTokenDto toUserTokenDto(User user);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    User toUser(UserRegisterDto userRegisterDto);
    
}