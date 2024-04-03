package com.example.demo.dto.message;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageDto {
    private Integer code;
    private String message;
}