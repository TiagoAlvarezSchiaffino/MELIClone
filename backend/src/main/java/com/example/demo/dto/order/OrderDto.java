package com.example.demo.dto.order;

import com.google.gson.annotations.SerializedName;
import com.example.demo.dto.address.AddressDetailPostDto;
import com.example.demo.dto.orderItem.OrderItemDto;
import com.example.demo.dto.orderStatus.OrderStatusDto;
import com.example.demo.dto.shippingMethod.ShippingMethodDto;
import com.example.demo.dto.user.UserRegisterDto;
import lombok.*;
import  com.example.demo.dto.user.UserDto;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int id;
    @SerializedName("fecha")
    private Date date;

    private UserRegisterDto user;
    private AddressDetailPostDto shippingAddress;
    private double orderTotal;
    private ShippingMethodDto shippingMethod;
    private OrderStatusDto orderStatus;

    //    private Set<OrderItemDto> items = new HashSet<>();
}