package com.example.demo.service;

import com.example.demo.dto.province.ProvinceDto;

import java.util.List;

public interface IProvinceService {
    ProvinceDto validZipCode(String zipCode);

    ProvinceDto findByName(String name);

}