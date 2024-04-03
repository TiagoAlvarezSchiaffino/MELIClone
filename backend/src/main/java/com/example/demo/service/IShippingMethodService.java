package com.example.demo.service;


import com.example.demo.dto.shippingMethod.ShippingMethodDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.ShippingMethod;

import java.util.List;

public interface IShippingMethodService {
    List<ShippingMethodDto> getAll();
    ShippingMethodDto getById(int id) throws ResourceNotFoundException;

    ShippingMethodDto post(ShippingMethod shippingMethod);

    ShippingMethodDto patch(int id,ShippingMethod shippingMethod) throws ResourceNotFoundException;

    ShippingMethodDto delete(int id) throws ResourceNotFoundException;


}