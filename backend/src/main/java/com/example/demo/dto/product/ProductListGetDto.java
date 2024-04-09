package com.example.demo.dto.product;

import com.example.demo.dto.image.ImageDto;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class ProductListGetDto {


    private Integer id;
    private String title;
    private Double price;
    private Integer numberQuotas;
    private Double priceQuotas;
    private Integer discount;
    private Double priceDiscount;
    private List<ImageDto> images;

}