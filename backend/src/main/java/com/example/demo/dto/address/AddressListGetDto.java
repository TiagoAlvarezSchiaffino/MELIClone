package com.example.demo.dto.address;

import com.example.demo.dto.province.ProvinceDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressListGetDto {
    private String contact;
    private ProvinceDto province;
    private String street;
    private String number;
}