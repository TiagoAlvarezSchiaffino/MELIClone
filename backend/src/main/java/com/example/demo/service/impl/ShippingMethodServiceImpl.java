package com.example.demo.service.impl;

import com.example.demo.dto.shippingMethod.ShippingMethodDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.IShippingMethodMapper;
import com.example.demo.model.entity.ShippingMethod;
import com.example.demo.repository.IShippingMethodRepository;
import com.example.demo.service.IShippingMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShippingMethodServiceImpl implements IShippingMethodService {
    @Autowired
    private IShippingMethodRepository shippingMethodRepository;

    @Autowired
    private IShippingMethodMapper shippingMethodMapper;


    @Override
    public List<ShippingMethodDto> getAll() {
        return shippingMethodMapper.toShippingMethodsDTO(shippingMethodRepository.findAll());
    }


    @Override
    public ShippingMethodDto getById(Long id) throws ResourceNotFoundException {
        ShippingMethod shippingMethod = shippingMethodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShippingMethod with id " + id + " not found"));
        return shippingMethodMapper.toShippingMethodDto(shippingMethod);
    }


    @Override
    public ShippingMethodDto post(ShippingMethod shippingMethod) {
        ShippingMethod savedShippingMethod = shippingMethodRepository.save(shippingMethod);
        return shippingMethodMapper.toShippingMethodDto(savedShippingMethod);
    }




    @Override
    public ShippingMethodDto patch(Long id, ShippingMethod shippingMethod) throws ResourceNotFoundException {
        ShippingMethod existingShippingMethod = shippingMethodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShippingMethod with id " + id + " not found"));
        if (shippingMethod.getName() != null) {
            existingShippingMethod.setName(shippingMethod.getName());
        }
        ShippingMethod updatedShippingMethod = shippingMethodRepository.save(existingShippingMethod);
        return shippingMethodMapper.toShippingMethodDto(updatedShippingMethod);
    }

    @Override
    public ShippingMethodDto delete(Long id) throws ResourceNotFoundException {
        ShippingMethod shippingMethodToDelete = shippingMethodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShippingMethod with id " + id + " not found"));
        shippingMethodRepository.delete(shippingMethodToDelete);
        return shippingMethodMapper.toShippingMethodDto(shippingMethodToDelete);
    }


}