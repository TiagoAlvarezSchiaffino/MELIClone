package com.example.demo.dto.order;

import com.google.gson.annotations.SerializedName;
import com.example.demo.dto.orderStatus.OrderStatusDto;
import com.example.demo.dto.shippingMethod.ShippingMethodDto;
import lombok.*;
import  com.example.demo.dto.user.UserDto;
import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int id;
    @SerializedName("fecha")
    private Date date;

    private UserDto user;
  //  private AdrressDto shippingAddress;
    private double orderTotal;
    private ShippingMethodDto shippingMethod;
    private OrderStatusDto orderStatus;

}