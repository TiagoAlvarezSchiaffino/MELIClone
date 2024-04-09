package com.example.demo.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.example.demo.dto.address.AddressDetailPostDto;
import com.example.demo.dto.orderStatus.OrderStatusDto;
import com.example.demo.dto.shippingMethod.ShippingMethodDto;

import java.util.Date;

public class OrderDetailPostDto {
    @JsonProperty("order_id")
    private  Long id;
    @SerializedName("Date")
    @JsonProperty("date")
    private Date date;
    private AddressDetailPostDto shippingAddress;
    @JsonProperty("order_total")
    private double orderTotal;
    private ShippingMethodDto shippingMethod;
    private OrderStatusDto orderStatus;
}