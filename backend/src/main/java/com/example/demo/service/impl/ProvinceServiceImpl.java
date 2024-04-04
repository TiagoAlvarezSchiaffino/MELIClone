package com.example.demo.service.impl;

import com.example.demo.dto.apilading.DataDto;
import com.example.demo.dto.province.ProvinceDto;
import com.example.demo.mapper.IProvinceMapper;
import com.example.demo.model.entity.Province;
import com.example.demo.repository.IProvinceRepository;
import com.example.demo.service.IProvinceService;
import com.example.demo.util.apilanding.IApiLandingExecute;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements IProvinceService {


    Logger logger = LoggerFactory.getLogger(ProvinceServiceImpl.class);

    private final IProvinceRepository provinceRepository;

    private final IApiLandingExecute apiLandingExecute;


    private final IProvinceMapper provinceMapper;

    @Override
    public ProvinceDto findByName(String name) {
        name = name.toLowerCase();
        Optional<Province> byNameContainingIgnoreCase = this.provinceRepository.findByNameContainingIgnoreCase(name);
        return this.provinceRepository.findByNameContainingIgnoreCase(name).map(provinceMapper::toProvinceDto)
                .orElseThrow(() -> new RuntimeException("El nombre de la provincia no existe."));
    }


    @Override
    public ProvinceDto validZipCode(String zipCode) {
        List<DataDto> data = apiLandingExecute.executeValidZipCode(zipCode).getData();
        DataDto dataDto = data.get(0);
        ProvinceDto byName = this.findByName(dataDto.getProvince());
        byName.setLocality(dataDto.getLocality().charAt(0)
        + dataDto.getLocality().substring(1).toLowerCase());
        return byName;
    }

}