package com.example.demo.dto.description;

import com.example.demo.model.enums.DescriptionEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DescriptionDto {


    private String content;
    
}