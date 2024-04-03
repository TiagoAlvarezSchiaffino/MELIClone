package com.example.demo.dto.apilading;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ResponseDto {
    private List<DataDto> data;
}