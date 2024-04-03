package com.example.demo.service;

import com.example.demo.address.AddressDetailPostDto;
import com.example.demo.address.AddressListGetDto;
import com.example.demo.address.AddressPostDto;
import com.example.demo.address.AddressUpdatePostDto;

import java.util.List;

public interface IAddressService {

    List<AddressListGetDto> findAllByUserId(Integer userId);

    AddressDetailPostDto findById(Integer addressId);

    AddressListGetDto findByUserIdAndStatusTrue(Integer userId);

    AddressPostDto save(AddressPostDto addressPostDto);


    AddressDetailPostDto update(Integer addressId, AddressUpdatePostDto addressUpdatePostDto);


    void updateStatus(Integer userId, Integer addressId);

    void deleteById(Integer idAddress);

}