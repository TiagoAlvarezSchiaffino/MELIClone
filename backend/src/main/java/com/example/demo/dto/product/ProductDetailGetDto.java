package com.example.demo.dto.product;

import com.example.demo.dto.category.CategoryDto;
import com.example.demo.dto.color.ColorDto;
import com.example.demo.dto.description.DescriptionDto;
import com.example.demo.dto.image.ImageDto;
import com.example.demo.dto.subcategory.SubcategoryGetProductDetailDto;
import com.example.demo.model.entity.Color;
import com.example.demo.model.entity.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDetailGetDto {

    private Integer id;
    private String title;
    private Double price;
    private Integer numberQuotas;
    private Double priceQuotas;
    private Integer discount;
    private Double priceDiscount;
    private List<ImageDto> images;
    private List<DescriptionDto> descriptionGeneric;
    private List<DescriptionDto> descriptionRelevant;
    private List<ColorDto> colors;
    private CategoryDto category;
    private SubcategoryGetProductDetailDto subcategory;


}