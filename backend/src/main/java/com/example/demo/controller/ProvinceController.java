package com.example.demo.controller;

import com.example.demo.dto.province.ProvinceDto;
import com.example.demo.service.IProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/provinces")
@RequiredArgsConstructor
public class ProvinceController {

    private final IProvinceService provincesService;


    @GetMapping("")
    public ResponseEntity<ProvinceDto> findByZipCode(@RequestParam(name = "zipcode") String zipCode) {
        return new ResponseEntity<>(provincesService.validZipCode(zipCode), HttpStatus.OK);
    }
}