package com.example.demo.service;

import com.example.demo.dto.location.LocalityDto;

import java.util.List;

public interface ILocationService {

    List<LocalityDto> findAllByIdProvince(String idProvince);
}